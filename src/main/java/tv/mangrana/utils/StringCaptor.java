package tv.mangrana.utils;

import tv.mangrana.exception.IncorrectWorkingReferencesException;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCaptor {

    public static String getMatchingSubstring(String fullText, String matchingRegex) {
        Pattern pattern = Pattern.compile(matchingRegex);
        Matcher matcher = pattern.matcher(fullText);
        return matcher.find() ? matcher.group(1) : null;
    }

    public static String getSeasonFolderNameFromSeason(String seasonFolderName) throws IncorrectWorkingReferencesException {
        Optional<String> typicalFormat = Optional.ofNullable(StringCaptor.getMatchingSubstring(seasonFolderName, "(S\\d{2})"));
        if (typicalFormat.isPresent()) {
            return typicalFormat.get().replaceFirst("S", "Temporada ");
        }
        Optional<String> weirdFormat = Optional.ofNullable(StringCaptor.getMatchingSubstring(seasonFolderName, "(T\\d{1,2})"));
        if (weirdFormat.isPresent()) {
            return weirdFormat.get().replaceFirst("T", "Temporada ");
        }
        throw new IncorrectWorkingReferencesException("Couldn't determinate the season from: "+seasonFolderName);
    }

    public static String getSeasonFolderNameFromEpisode(String episodeFileName) throws IncorrectWorkingReferencesException {
        String episodeInfo = Optional.ofNullable(
                        StringCaptor.getMatchingSubstring(episodeFileName, "(S\\d{2}E\\d{2})"))
                .orElseThrow(() ->
                        new IncorrectWorkingReferencesException("Couldn't determinate the episode from: "+episodeFileName));
        return "Temporada ".concat(episodeInfo.substring(1,3));
    }

}
