import edu.duke.*;
import java.util.regex.*;

public class Part4 {
    public void findYouTubeLinks() {
        String url = "https://www.dukelearntoprogram.com/course2/data/manylinks.html";
        URLResource ur = new URLResource(url);

        int foundLinks = 0;
        System.out.println("Fetching and scanning webpage content from: " + url);

        // Read content from URL
        String content = ur.asString();
        System.out.println("Content length: " + content.length() + " characters");

        // Regex pattern for YouTube links
        Pattern youtubePattern = Pattern.compile("https?://(?:www\\.)?(youtube\\.com|youtu\\.be)[^\\s\"<>]*", Pattern.CASE_INSENSITIVE);
        Matcher m = youtubePattern.matcher(content);

        // Iterate over matches and print found URLs
        while (m.find()) {
            String youtubeURL = m.group();
            foundLinks++;
            System.out.println(youtubeURL);
        }

        System.out.println("\nTotal YouTube links found: " + foundLinks);
    }
}
