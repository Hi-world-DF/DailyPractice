package src.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Derek.Wang
 * @email derek.wang@cecport.com
 * @date 2025/7/8 16:34
 */
public class PdfCropAndRemoveLastPage {
    // 要处理的源文件夹路径
    private static final String INPUT_FOLDER = "D:\\Life\\资料\\software_designer\\03. 官方教材+教辅";
    // 输出文件夹路径
    private static final String OUTPUT_FOLDER = "D:\\Life\\资料\\software_designer\\03. 官方教材+教辅\\output";
    // 每页顶部要遮盖的高度（单位 pt）
    private static final float TOP_HEIGHT_TO_COVER = 30f;

    public static void main(String[] args) {
        File inputFolder = new File(INPUT_FOLDER);
        if (!inputFolder.exists() || !inputFolder.isDirectory()) {
            System.out.println("输入路径不是有效文件夹");
            return;
        }

        // 创建输出文件夹
        File outputFolderFile = new File(OUTPUT_FOLDER);
        if (!outputFolderFile.exists()) {
            outputFolderFile.mkdirs();
        }

        // 获取所有 .pdf 文件
        List<File> pdfFiles = new ArrayList<>();
        collectPDFs(inputFolder, pdfFiles);

        for (File file : pdfFiles) {
            String srcPath = file.getAbsolutePath();
            String destName = file.getName();
            String destPath = new File(outputFolderFile, destName).getAbsolutePath();

            try {
                processPdf(srcPath, destPath);
                System.out.println("已处理: " + file.getName());
            } catch (Exception e) {
                System.err.println("处理失败: " + file.getName());
                e.printStackTrace();
            }
        }

        System.out.println("批量处理完成！");
    }

    /**
     * 收集所有 PDF 文件（递归）
     */
    private static void collectPDFs(File folder, List<File> list) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                collectPDFs(file, list);
            } else if (file.getName().toLowerCase().endsWith(".pdf")) {
                list.add(file);
            }
        }
    }

    /**
     * 处理单个 PDF 文件
     */
    private static void processPdf(String srcPath, String destPath) throws Exception {
        PdfReader reader = new PdfReader(srcPath);
        int totalPages = reader.getNumberOfPages();

        if (totalPages <= 1) {
            System.out.println("跳过（页数不足）: " + srcPath);
            reader.close();
            return;
        }

        // Step 1: 创建临时文件，排除最后一页
        String tempFile = createTempFile();
        writeWithoutLastPage(reader, tempFile, totalPages);

        // Step 2: 添加顶部遮盖
        addTopCover(tempFile, destPath, TOP_HEIGHT_TO_COVER);

        reader.close();
    }

    /**
     * 第一步：写入不包含最后一页的新 PDF
     */
    private static void writeWithoutLastPage(PdfReader reader, String dest, int totalPages) throws Exception {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();

        PdfContentByte cb = writer.getDirectContent();

        for (int i = 2; i <= totalPages; i++) {
            document.newPage();
            PdfImportedPage page = writer.getImportedPage(reader, i);
            cb.addTemplate(page, 0, 0);
        }

        document.close();
    }

    /**
     * 第二步：在每一页顶部添加遮盖
     */
    private static void addTopCover(String src, String dest, float topHeight) throws Exception {
        PdfReader reader = new PdfReader(src);
        int totalPages = reader.getNumberOfPages();

        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));

        for (int i = 1; i <= totalPages; i++) {
            Rectangle pageSize = reader.getPageSizeWithRotation(i);

            // 顶部遮盖
            float topY = pageSize.getTop() - topHeight;
            float width = pageSize.getWidth();
            float height = topHeight;

            // 底部遮盖
            float bottomY = pageSize.getBottom();

            PdfContentByte canvas = stamper.getOverContent(i);
            if (canvas != null) {
                canvas.saveState();
                canvas.setColorFill(com.itextpdf.text.BaseColor.WHITE);

                // 绘制顶部遮盖
                canvas.rectangle(pageSize.getLeft(), topY, width, height);
                canvas.fill();

                // 绘制底部遮盖
                canvas.rectangle(pageSize.getLeft(), bottomY, width, height);
                canvas.fill();

                canvas.restoreState();
            }
        }

        stamper.close();
        reader.close();
    }

    /**
     * 创建临时文件路径
     */
    private static String createTempFile() throws IOException {
        File tempFile = File.createTempFile("temp_", ".pdf");
        tempFile.deleteOnExit();
        return tempFile.getAbsolutePath();
    }
}
