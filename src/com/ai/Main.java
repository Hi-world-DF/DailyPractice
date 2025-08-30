package src.com.ai;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.util.Properties;

/**
 * @description:
 * @author: laomao
 * @date: 1/4/2025 下午 8:47
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // 提取PDF文本
        String pdfPath = "path/to/your/pdfFile.pdf";
        PDDocument document = PDDocument.load(new File(pdfPath));
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        document.close();

        // 使用Stanford NLP进行处理
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        CoreDocument doc = new CoreDocument(text);
        pipeline.annotate(doc);

        for (CoreLabel token: doc.tokens()) {
            System.out.println(token.originalText());
        }
    }
}
