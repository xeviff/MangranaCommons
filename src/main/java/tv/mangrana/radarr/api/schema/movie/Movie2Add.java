package tv.mangrana.radarr.api.schema.movie;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "originalTitle",
        "originalLanguage",
        "alternateTitles",
        "secondaryYear",
        "secondaryYearSourceId",
        "sortTitle",
        "sizeOnDisk",
        "status",
        "overview",
        "inCinemas",
        "physicalRelease",
        "digitalRelease",
        "physicalReleaseNote",
        "images",
        "website",
        "remotePoster",
        "year",
        "hasFile",
        "youTubeTrailerId",
        "studio",
        "path",
        "qualityProfileId",
        "monitored",
        "minimumAvailability",
        "isAvailable",
        "folderName",
        "runtime",
        "cleanTitle",
        "imdbId",
        "tmdbId",
        "titleSlug",
        "rootFolderPath",
        "folder",
        "certification",
        "genres",
        "tags",
        "added",
        "addOptions",
        "ratings",
        "movieFile",
        "collection",
        "popularity"
})
@Generated("jsonschema2pojo")
public class Movie2Add {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("originalTitle")
    private String originalTitle;
    @JsonProperty("originalLanguage")
    private OriginalLanguage originalLanguage;
    @JsonProperty("alternateTitles")
    private List<AlternateTitle> alternateTitles;
    @JsonProperty("secondaryYear")
    private Integer secondaryYear;
    @JsonProperty("secondaryYearSourceId")
    private Integer secondaryYearSourceId;
    @JsonProperty("sortTitle")
    private String sortTitle;
    @JsonProperty("sizeOnDisk")
    private Integer sizeOnDisk;
    @JsonProperty("status")
    private String status;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("inCinemas")
    private String inCinemas;
    @JsonProperty("physicalRelease")
    private String physicalRelease;
    @JsonProperty("digitalRelease")
    private String digitalRelease;
    @JsonProperty("physicalReleaseNote")
    private String physicalReleaseNote;
    @JsonProperty("images")
    private List<Image> images;
    @JsonProperty("website")
    private String website;
    @JsonProperty("remotePoster")
    private String remotePoster;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("hasFile")
    private Boolean hasFile;
    @JsonProperty("youTubeTrailerId")
    private String youTubeTrailerId;
    @JsonProperty("studio")
    private String studio;
    @JsonProperty("path")
    private String path;
    @JsonProperty("qualityProfileId")
    private Integer qualityProfileId;
    @JsonProperty("monitored")
    private Boolean monitored;
    @JsonProperty("minimumAvailability")
    private String minimumAvailability;
    @JsonProperty("isAvailable")
    private Boolean isAvailable;
    @JsonProperty("folderName")
    private String folderName;
    @JsonProperty("runtime")
    private Integer runtime;
    @JsonProperty("cleanTitle")
    private String cleanTitle;
    @JsonProperty("imdbId")
    private String imdbId;
    @JsonProperty("tmdbId")
    private Integer tmdbId;
    @JsonProperty("titleSlug")
    private String titleSlug;
    @JsonProperty("rootFolderPath")
    private String rootFolderPath;
    @JsonProperty("folder")
    private String folder;
    @JsonProperty("certification")
    private String certification;
    @JsonProperty("genres")
    private List<String> genres;
    @JsonProperty("tags")
    private List<Integer> tags;
    @JsonProperty("added")
    private String added;
    @JsonProperty("addOptions")
    private AddOptions addOptions;
    @JsonProperty("ratings")
    private Ratings ratings;
    @JsonProperty("movieFile")
    private MovieFile movieFile;
    @JsonProperty("collection")
    private Collection collection;
    @JsonProperty("popularity")
    private Integer popularity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("originalTitle")
    public String getOriginalTitle() {
        return originalTitle;
    }

    @JsonProperty("originalTitle")
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @JsonProperty("originalLanguage")
    public OriginalLanguage getOriginalLanguage() {
        return originalLanguage;
    }

    @JsonProperty("originalLanguage")
    public void setOriginalLanguage(OriginalLanguage originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @JsonProperty("alternateTitles")
    public List<AlternateTitle> getAlternateTitles() {
        return alternateTitles;
    }

    @JsonProperty("alternateTitles")
    public void setAlternateTitles(List<AlternateTitle> alternateTitles) {
        this.alternateTitles = alternateTitles;
    }

    @JsonProperty("secondaryYear")
    public Integer getSecondaryYear() {
        return secondaryYear;
    }

    @JsonProperty("secondaryYear")
    public void setSecondaryYear(Integer secondaryYear) {
        this.secondaryYear = secondaryYear;
    }

    @JsonProperty("secondaryYearSourceId")
    public Integer getSecondaryYearSourceId() {
        return secondaryYearSourceId;
    }

    @JsonProperty("secondaryYearSourceId")
    public void setSecondaryYearSourceId(Integer secondaryYearSourceId) {
        this.secondaryYearSourceId = secondaryYearSourceId;
    }

    @JsonProperty("sortTitle")
    public String getSortTitle() {
        return sortTitle;
    }

    @JsonProperty("sortTitle")
    public void setSortTitle(String sortTitle) {
        this.sortTitle = sortTitle;
    }

    @JsonProperty("sizeOnDisk")
    public Integer getSizeOnDisk() {
        return sizeOnDisk;
    }

    @JsonProperty("sizeOnDisk")
    public void setSizeOnDisk(Integer sizeOnDisk) {
        this.sizeOnDisk = sizeOnDisk;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("inCinemas")
    public String getInCinemas() {
        return inCinemas;
    }

    @JsonProperty("inCinemas")
    public void setInCinemas(String inCinemas) {
        this.inCinemas = inCinemas;
    }

    @JsonProperty("physicalRelease")
    public String getPhysicalRelease() {
        return physicalRelease;
    }

    @JsonProperty("physicalRelease")
    public void setPhysicalRelease(String physicalRelease) {
        this.physicalRelease = physicalRelease;
    }

    @JsonProperty("digitalRelease")
    public String getDigitalRelease() {
        return digitalRelease;
    }

    @JsonProperty("digitalRelease")
    public void setDigitalRelease(String digitalRelease) {
        this.digitalRelease = digitalRelease;
    }

    @JsonProperty("physicalReleaseNote")
    public String getPhysicalReleaseNote() {
        return physicalReleaseNote;
    }

    @JsonProperty("physicalReleaseNote")
    public void setPhysicalReleaseNote(String physicalReleaseNote) {
        this.physicalReleaseNote = physicalReleaseNote;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonProperty("remotePoster")
    public String getRemotePoster() {
        return remotePoster;
    }

    @JsonProperty("remotePoster")
    public void setRemotePoster(String remotePoster) {
        this.remotePoster = remotePoster;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("hasFile")
    public Boolean getHasFile() {
        return hasFile;
    }

    @JsonProperty("hasFile")
    public void setHasFile(Boolean hasFile) {
        this.hasFile = hasFile;
    }

    @JsonProperty("youTubeTrailerId")
    public String getYouTubeTrailerId() {
        return youTubeTrailerId;
    }

    @JsonProperty("youTubeTrailerId")
    public void setYouTubeTrailerId(String youTubeTrailerId) {
        this.youTubeTrailerId = youTubeTrailerId;
    }

    @JsonProperty("studio")
    public String getStudio() {
        return studio;
    }

    @JsonProperty("studio")
    public void setStudio(String studio) {
        this.studio = studio;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("qualityProfileId")
    public Integer getQualityProfileId() {
        return qualityProfileId;
    }

    @JsonProperty("qualityProfileId")
    public void setQualityProfileId(Integer qualityProfileId) {
        this.qualityProfileId = qualityProfileId;
    }

    @JsonProperty("monitored")
    public Boolean getMonitored() {
        return monitored;
    }

    @JsonProperty("monitored")
    public void setMonitored(Boolean monitored) {
        this.monitored = monitored;
    }

    @JsonProperty("minimumAvailability")
    public String getMinimumAvailability() {
        return minimumAvailability;
    }

    @JsonProperty("minimumAvailability")
    public void setMinimumAvailability(String minimumAvailability) {
        this.minimumAvailability = minimumAvailability;
    }

    @JsonProperty("isAvailable")
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    @JsonProperty("isAvailable")
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @JsonProperty("folderName")
    public String getFolderName() {
        return folderName;
    }

    @JsonProperty("folderName")
    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @JsonProperty("runtime")
    public Integer getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("cleanTitle")
    public String getCleanTitle() {
        return cleanTitle;
    }

    @JsonProperty("cleanTitle")
    public void setCleanTitle(String cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    @JsonProperty("imdbId")
    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("imdbId")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @JsonProperty("tmdbId")
    public Integer getTmdbId() {
        return tmdbId;
    }

    @JsonProperty("tmdbId")
    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    @JsonProperty("titleSlug")
    public String getTitleSlug() {
        return titleSlug;
    }

    @JsonProperty("titleSlug")
    public void setTitleSlug(String titleSlug) {
        this.titleSlug = titleSlug;
    }

    @JsonProperty("rootFolderPath")
    public String getRootFolderPath() {
        return rootFolderPath;
    }

    @JsonProperty("rootFolderPath")
    public void setRootFolderPath(String rootFolderPath) {
        this.rootFolderPath = rootFolderPath;
    }

    @JsonProperty("folder")
    public String getFolder() {
        return folder;
    }

    @JsonProperty("folder")
    public void setFolder(String folder) {
        this.folder = folder;
    }

    @JsonProperty("certification")
    public String getCertification() {
        return certification;
    }

    @JsonProperty("certification")
    public void setCertification(String certification) {
        this.certification = certification;
    }

    @JsonProperty("genres")
    public List<String> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @JsonProperty("tags")
    public List<Integer> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

    @JsonProperty("added")
    public String getAdded() {
        return added;
    }

    @JsonProperty("added")
    public void setAdded(String added) {
        this.added = added;
    }

    @JsonProperty("addOptions")
    public AddOptions getAddOptions() {
        return addOptions;
    }

    @JsonProperty("addOptions")
    public void setAddOptions(AddOptions addOptions) {
        this.addOptions = addOptions;
    }

    @JsonProperty("ratings")
    public Ratings getRatings() {
        return ratings;
    }

    @JsonProperty("ratings")
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    @JsonProperty("movieFile")
    public MovieFile getMovieFile() {
        return movieFile;
    }

    @JsonProperty("movieFile")
    public void setMovieFile(MovieFile movieFile) {
        this.movieFile = movieFile;
    }

    @JsonProperty("collection")
    public Collection getCollection() {
        return collection;
    }

    @JsonProperty("collection")
    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    @JsonProperty("popularity")
    public Integer getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "cleanTitle",
        "sortTitle",
        "tmdbId",
        "overview",
        "monitored",
        "qualityProfileId",
        "rootFolderPath",
        "searchOnAdd",
        "minimumAvailability",
        "lastInfoSync",
        "images",
        "added",
        "movies"
})
@Generated("jsonschema2pojo")
 class Collection {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("cleanTitle")
    private String cleanTitle;
    @JsonProperty("sortTitle")
    private String sortTitle;
    @JsonProperty("tmdbId")
    private Integer tmdbId;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("monitored")
    private Boolean monitored;
    @JsonProperty("qualityProfileId")
    private Integer qualityProfileId;
    @JsonProperty("rootFolderPath")
    private String rootFolderPath;
    @JsonProperty("searchOnAdd")
    private Boolean searchOnAdd;
    @JsonProperty("minimumAvailability")
    private String minimumAvailability;
    @JsonProperty("lastInfoSync")
    private String lastInfoSync;
    @JsonProperty("images")
    private List<Image> images;
    @JsonProperty("added")
    private String added;
    @JsonProperty("movies")
    private List<Movie> movies;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("cleanTitle")
    public String getCleanTitle() {
        return cleanTitle;
    }

    @JsonProperty("cleanTitle")
    public void setCleanTitle(String cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    @JsonProperty("sortTitle")
    public String getSortTitle() {
        return sortTitle;
    }

    @JsonProperty("sortTitle")
    public void setSortTitle(String sortTitle) {
        this.sortTitle = sortTitle;
    }

    @JsonProperty("tmdbId")
    public Integer getTmdbId() {
        return tmdbId;
    }

    @JsonProperty("tmdbId")
    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("monitored")
    public Boolean getMonitored() {
        return monitored;
    }

    @JsonProperty("monitored")
    public void setMonitored(Boolean monitored) {
        this.monitored = monitored;
    }

    @JsonProperty("qualityProfileId")
    public Integer getQualityProfileId() {
        return qualityProfileId;
    }

    @JsonProperty("qualityProfileId")
    public void setQualityProfileId(Integer qualityProfileId) {
        this.qualityProfileId = qualityProfileId;
    }

    @JsonProperty("rootFolderPath")
    public String getRootFolderPath() {
        return rootFolderPath;
    }

    @JsonProperty("rootFolderPath")
    public void setRootFolderPath(String rootFolderPath) {
        this.rootFolderPath = rootFolderPath;
    }

    @JsonProperty("searchOnAdd")
    public Boolean getSearchOnAdd() {
        return searchOnAdd;
    }

    @JsonProperty("searchOnAdd")
    public void setSearchOnAdd(Boolean searchOnAdd) {
        this.searchOnAdd = searchOnAdd;
    }

    @JsonProperty("minimumAvailability")
    public String getMinimumAvailability() {
        return minimumAvailability;
    }

    @JsonProperty("minimumAvailability")
    public void setMinimumAvailability(String minimumAvailability) {
        this.minimumAvailability = minimumAvailability;
    }

    @JsonProperty("lastInfoSync")
    public String getLastInfoSync() {
        return lastInfoSync;
    }

    @JsonProperty("lastInfoSync")
    public void setLastInfoSync(String lastInfoSync) {
        this.lastInfoSync = lastInfoSync;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("added")
    public String getAdded() {
        return added;
    }

    @JsonProperty("added")
    public void setAdded(String added) {
        this.added = added;
    }

    @JsonProperty("movies")
    public List<Movie> getMovies() {
        return movies;
    }

    @JsonProperty("movies")
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "includeCustomFormatWhenRenaming",
        "specifications"
})
@Generated("jsonschema2pojo")
 class CustomFormat {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("includeCustomFormatWhenRenaming")
    private Boolean includeCustomFormatWhenRenaming;
    @JsonProperty("specifications")
    private List<Specification> specifications;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("includeCustomFormatWhenRenaming")
    public Boolean getIncludeCustomFormatWhenRenaming() {
        return includeCustomFormatWhenRenaming;
    }

    @JsonProperty("includeCustomFormatWhenRenaming")
    public void setIncludeCustomFormatWhenRenaming(Boolean includeCustomFormatWhenRenaming) {
        this.includeCustomFormatWhenRenaming = includeCustomFormatWhenRenaming;
    }

    @JsonProperty("specifications")
    public List<Specification> getSpecifications() {
        return specifications;
    }

    @JsonProperty("specifications")
    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "order",
        "name",
        "label",
        "unit",
        "helpText",
        "helpLink",
        "value",
        "type",
        "advanced",
        "selectOptions",
        "selectOptionsProviderAction",
        "section",
        "hidden",
        "placeholder"
})
@Generated("jsonschema2pojo")
 class Field {

    @JsonProperty("order")
    private Integer order;
    @JsonProperty("name")
    private String name;
    @JsonProperty("label")
    private String label;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("helpText")
    private String helpText;
    @JsonProperty("helpLink")
    private String helpLink;
    @JsonProperty("value")
    private String value;
    @JsonProperty("type")
    private String type;
    @JsonProperty("advanced")
    private Boolean advanced;
    @JsonProperty("selectOptions")
    private List<SelectOption> selectOptions;
    @JsonProperty("selectOptionsProviderAction")
    private String selectOptionsProviderAction;
    @JsonProperty("section")
    private String section;
    @JsonProperty("hidden")
    private String hidden;
    @JsonProperty("placeholder")
    private String placeholder;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("order")
    public Integer getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(Integer order) {
        this.order = order;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonProperty("helpText")
    public String getHelpText() {
        return helpText;
    }

    @JsonProperty("helpText")
    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    @JsonProperty("helpLink")
    public String getHelpLink() {
        return helpLink;
    }

    @JsonProperty("helpLink")
    public void setHelpLink(String helpLink) {
        this.helpLink = helpLink;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("advanced")
    public Boolean getAdvanced() {
        return advanced;
    }

    @JsonProperty("advanced")
    public void setAdvanced(Boolean advanced) {
        this.advanced = advanced;
    }

    @JsonProperty("selectOptions")
    public List<SelectOption> getSelectOptions() {
        return selectOptions;
    }

    @JsonProperty("selectOptions")
    public void setSelectOptions(List<SelectOption> selectOptions) {
        this.selectOptions = selectOptions;
    }

    @JsonProperty("selectOptionsProviderAction")
    public String getSelectOptionsProviderAction() {
        return selectOptionsProviderAction;
    }

    @JsonProperty("selectOptionsProviderAction")
    public void setSelectOptionsProviderAction(String selectOptionsProviderAction) {
        this.selectOptionsProviderAction = selectOptionsProviderAction;
    }

    @JsonProperty("section")
    public String getSection() {
        return section;
    }

    @JsonProperty("section")
    public void setSection(String section) {
        this.section = section;
    }

    @JsonProperty("hidden")
    public String getHidden() {
        return hidden;
    }

    @JsonProperty("hidden")
    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    @JsonProperty("placeholder")
    public String getPlaceholder() {
        return placeholder;
    }

    @JsonProperty("placeholder")
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "audioBitrate",
        "audioChannels",
        "audioCodec",
        "audioLanguages",
        "audioStreamCount",
        "videoBitDepth",
        "videoBitrate",
        "videoCodec",
        "videoDynamicRangeType",
        "videoFps",
        "resolution",
        "runTime",
        "scanType",
        "subtitles"
})
@Generated("jsonschema2pojo")
 class MediaInfo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("audioBitrate")
    private Integer audioBitrate;
    @JsonProperty("audioChannels")
    private Integer audioChannels;
    @JsonProperty("audioCodec")
    private String audioCodec;
    @JsonProperty("audioLanguages")
    private String audioLanguages;
    @JsonProperty("audioStreamCount")
    private Integer audioStreamCount;
    @JsonProperty("videoBitDepth")
    private Integer videoBitDepth;
    @JsonProperty("videoBitrate")
    private Integer videoBitrate;
    @JsonProperty("videoCodec")
    private String videoCodec;
    @JsonProperty("videoDynamicRangeType")
    private String videoDynamicRangeType;
    @JsonProperty("videoFps")
    private Integer videoFps;
    @JsonProperty("resolution")
    private String resolution;
    @JsonProperty("runTime")
    private String runTime;
    @JsonProperty("scanType")
    private String scanType;
    @JsonProperty("subtitles")
    private String subtitles;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("audioBitrate")
    public Integer getAudioBitrate() {
        return audioBitrate;
    }

    @JsonProperty("audioBitrate")
    public void setAudioBitrate(Integer audioBitrate) {
        this.audioBitrate = audioBitrate;
    }

    @JsonProperty("audioChannels")
    public Integer getAudioChannels() {
        return audioChannels;
    }

    @JsonProperty("audioChannels")
    public void setAudioChannels(Integer audioChannels) {
        this.audioChannels = audioChannels;
    }

    @JsonProperty("audioCodec")
    public String getAudioCodec() {
        return audioCodec;
    }

    @JsonProperty("audioCodec")
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    @JsonProperty("audioLanguages")
    public String getAudioLanguages() {
        return audioLanguages;
    }

    @JsonProperty("audioLanguages")
    public void setAudioLanguages(String audioLanguages) {
        this.audioLanguages = audioLanguages;
    }

    @JsonProperty("audioStreamCount")
    public Integer getAudioStreamCount() {
        return audioStreamCount;
    }

    @JsonProperty("audioStreamCount")
    public void setAudioStreamCount(Integer audioStreamCount) {
        this.audioStreamCount = audioStreamCount;
    }

    @JsonProperty("videoBitDepth")
    public Integer getVideoBitDepth() {
        return videoBitDepth;
    }

    @JsonProperty("videoBitDepth")
    public void setVideoBitDepth(Integer videoBitDepth) {
        this.videoBitDepth = videoBitDepth;
    }

    @JsonProperty("videoBitrate")
    public Integer getVideoBitrate() {
        return videoBitrate;
    }

    @JsonProperty("videoBitrate")
    public void setVideoBitrate(Integer videoBitrate) {
        this.videoBitrate = videoBitrate;
    }

    @JsonProperty("videoCodec")
    public String getVideoCodec() {
        return videoCodec;
    }

    @JsonProperty("videoCodec")
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    @JsonProperty("videoDynamicRangeType")
    public String getVideoDynamicRangeType() {
        return videoDynamicRangeType;
    }

    @JsonProperty("videoDynamicRangeType")
    public void setVideoDynamicRangeType(String videoDynamicRangeType) {
        this.videoDynamicRangeType = videoDynamicRangeType;
    }

    @JsonProperty("videoFps")
    public Integer getVideoFps() {
        return videoFps;
    }

    @JsonProperty("videoFps")
    public void setVideoFps(Integer videoFps) {
        this.videoFps = videoFps;
    }

    @JsonProperty("resolution")
    public String getResolution() {
        return resolution;
    }

    @JsonProperty("resolution")
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @JsonProperty("runTime")
    public String getRunTime() {
        return runTime;
    }

    @JsonProperty("runTime")
    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    @JsonProperty("scanType")
    public String getScanType() {
        return scanType;
    }

    @JsonProperty("scanType")
    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    @JsonProperty("subtitles")
    public String getSubtitles() {
        return subtitles;
    }

    @JsonProperty("subtitles")
    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "votes",
        "value",
        "type"
})
@Generated("jsonschema2pojo")
 class Metacritic {

    @JsonProperty("votes")
    private Integer votes;
    @JsonProperty("value")
    private Integer value;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("votes")
    public Integer getVotes() {
        return votes;
    }

    @JsonProperty("votes")
    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "tmdbId",
        "images",
        "genres",
        "inCinemas",
        "physicalRelease",
        "digitalRelease",
        "certification",
        "year",
        "ratings",
        "collectionTmdbId",
        "collectionTitle",
        "lastInfoSync",
        "runtime",
        "website",
        "imdbId",
        "title",
        "cleanTitle",
        "sortTitle",
        "status",
        "overview",
        "alternativeTitles",
        "translations",
        "secondaryYear",
        "youTubeTrailerId",
        "studio",
        "originalTitle",
        "cleanOriginalTitle",
        "originalLanguage",
        "recommendations",
        "popularity"
})
@Generated("jsonschema2pojo")
 class Movie {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("tmdbId")
    private Integer tmdbId;
    @JsonProperty("images")
    private List<Image> images;
    @JsonProperty("genres")
    private List<String> genres;
    @JsonProperty("inCinemas")
    private String inCinemas;
    @JsonProperty("physicalRelease")
    private String physicalRelease;
    @JsonProperty("digitalRelease")
    private String digitalRelease;
    @JsonProperty("certification")
    private String certification;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("ratings")
    private Ratings ratings;
    @JsonProperty("collectionTmdbId")
    private Integer collectionTmdbId;
    @JsonProperty("collectionTitle")
    private String collectionTitle;
    @JsonProperty("lastInfoSync")
    private String lastInfoSync;
    @JsonProperty("runtime")
    private Integer runtime;
    @JsonProperty("website")
    private String website;
    @JsonProperty("imdbId")
    private String imdbId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("cleanTitle")
    private String cleanTitle;
    @JsonProperty("sortTitle")
    private String sortTitle;
    @JsonProperty("status")
    private String status;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("alternativeTitles")
    private List<AlternateTitle> alternativeTitles;
    @JsonProperty("translations")
    private List<Translation> translations;
    @JsonProperty("secondaryYear")
    private Integer secondaryYear;
    @JsonProperty("youTubeTrailerId")
    private String youTubeTrailerId;
    @JsonProperty("studio")
    private String studio;
    @JsonProperty("originalTitle")
    private String originalTitle;
    @JsonProperty("cleanOriginalTitle")
    private String cleanOriginalTitle;
    @JsonProperty("originalLanguage")
    private OriginalLanguage originalLanguage;
    @JsonProperty("recommendations")
    private List<Integer> recommendations;
    @JsonProperty("popularity")
    private Integer popularity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("tmdbId")
    public Integer getTmdbId() {
        return tmdbId;
    }

    @JsonProperty("tmdbId")
    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("genres")
    public List<String> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @JsonProperty("inCinemas")
    public String getInCinemas() {
        return inCinemas;
    }

    @JsonProperty("inCinemas")
    public void setInCinemas(String inCinemas) {
        this.inCinemas = inCinemas;
    }

    @JsonProperty("physicalRelease")
    public String getPhysicalRelease() {
        return physicalRelease;
    }

    @JsonProperty("physicalRelease")
    public void setPhysicalRelease(String physicalRelease) {
        this.physicalRelease = physicalRelease;
    }

    @JsonProperty("digitalRelease")
    public String getDigitalRelease() {
        return digitalRelease;
    }

    @JsonProperty("digitalRelease")
    public void setDigitalRelease(String digitalRelease) {
        this.digitalRelease = digitalRelease;
    }

    @JsonProperty("certification")
    public String getCertification() {
        return certification;
    }

    @JsonProperty("certification")
    public void setCertification(String certification) {
        this.certification = certification;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("ratings")
    public Ratings getRatings() {
        return ratings;
    }

    @JsonProperty("ratings")
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    @JsonProperty("collectionTmdbId")
    public Integer getCollectionTmdbId() {
        return collectionTmdbId;
    }

    @JsonProperty("collectionTmdbId")
    public void setCollectionTmdbId(Integer collectionTmdbId) {
        this.collectionTmdbId = collectionTmdbId;
    }

    @JsonProperty("collectionTitle")
    public String getCollectionTitle() {
        return collectionTitle;
    }

    @JsonProperty("collectionTitle")
    public void setCollectionTitle(String collectionTitle) {
        this.collectionTitle = collectionTitle;
    }

    @JsonProperty("lastInfoSync")
    public String getLastInfoSync() {
        return lastInfoSync;
    }

    @JsonProperty("lastInfoSync")
    public void setLastInfoSync(String lastInfoSync) {
        this.lastInfoSync = lastInfoSync;
    }

    @JsonProperty("runtime")
    public Integer getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonProperty("imdbId")
    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("imdbId")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("cleanTitle")
    public String getCleanTitle() {
        return cleanTitle;
    }

    @JsonProperty("cleanTitle")
    public void setCleanTitle(String cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    @JsonProperty("sortTitle")
    public String getSortTitle() {
        return sortTitle;
    }

    @JsonProperty("sortTitle")
    public void setSortTitle(String sortTitle) {
        this.sortTitle = sortTitle;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("alternativeTitles")
    public List<AlternateTitle> getAlternativeTitles() {
        return alternativeTitles;
    }

    @JsonProperty("alternativeTitles")
    public void setAlternativeTitles(List<AlternateTitle> alternativeTitles) {
        this.alternativeTitles = alternativeTitles;
    }

    @JsonProperty("translations")
    public List<Translation> getTranslations() {
        return translations;
    }

    @JsonProperty("translations")
    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    @JsonProperty("secondaryYear")
    public Integer getSecondaryYear() {
        return secondaryYear;
    }

    @JsonProperty("secondaryYear")
    public void setSecondaryYear(Integer secondaryYear) {
        this.secondaryYear = secondaryYear;
    }

    @JsonProperty("youTubeTrailerId")
    public String getYouTubeTrailerId() {
        return youTubeTrailerId;
    }

    @JsonProperty("youTubeTrailerId")
    public void setYouTubeTrailerId(String youTubeTrailerId) {
        this.youTubeTrailerId = youTubeTrailerId;
    }

    @JsonProperty("studio")
    public String getStudio() {
        return studio;
    }

    @JsonProperty("studio")
    public void setStudio(String studio) {
        this.studio = studio;
    }

    @JsonProperty("originalTitle")
    public String getOriginalTitle() {
        return originalTitle;
    }

    @JsonProperty("originalTitle")
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @JsonProperty("cleanOriginalTitle")
    public String getCleanOriginalTitle() {
        return cleanOriginalTitle;
    }

    @JsonProperty("cleanOriginalTitle")
    public void setCleanOriginalTitle(String cleanOriginalTitle) {
        this.cleanOriginalTitle = cleanOriginalTitle;
    }

    @JsonProperty("originalLanguage")
    public OriginalLanguage getOriginalLanguage() {
        return originalLanguage;
    }

    @JsonProperty("originalLanguage")
    public void setOriginalLanguage(OriginalLanguage originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @JsonProperty("recommendations")
    public List<Integer> getRecommendations() {
        return recommendations;
    }

    @JsonProperty("recommendations")
    public void setRecommendations(List<Integer> recommendations) {
        this.recommendations = recommendations;
    }

    @JsonProperty("popularity")
    public Integer getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "version",
        "real",
        "isRepack"
})
@Generated("jsonschema2pojo")
 class Revision {

    @JsonProperty("version")
    private Integer version;
    @JsonProperty("real")
    private Integer real;
    @JsonProperty("isRepack")
    private Boolean isRepack;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("real")
    public Integer getReal() {
        return real;
    }

    @JsonProperty("real")
    public void setReal(Integer real) {
        this.real = real;
    }

    @JsonProperty("isRepack")
    public Boolean getIsRepack() {
        return isRepack;
    }

    @JsonProperty("isRepack")
    public void setIsRepack(Boolean isRepack) {
        this.isRepack = isRepack;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "value",
        "name",
        "order",
        "hint",
        "dividerAfter"
})
@Generated("jsonschema2pojo")
 class SelectOption {

    @JsonProperty("value")
    private Integer value;
    @JsonProperty("name")
    private String name;
    @JsonProperty("order")
    private Integer order;
    @JsonProperty("hint")
    private String hint;
    @JsonProperty("dividerAfter")
    private Boolean dividerAfter;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("order")
    public Integer getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(Integer order) {
        this.order = order;
    }

    @JsonProperty("hint")
    public String getHint() {
        return hint;
    }

    @JsonProperty("hint")
    public void setHint(String hint) {
        this.hint = hint;
    }

    @JsonProperty("dividerAfter")
    public Boolean getDividerAfter() {
        return dividerAfter;
    }

    @JsonProperty("dividerAfter")
    public void setDividerAfter(Boolean dividerAfter) {
        this.dividerAfter = dividerAfter;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "implementation",
        "implementationName",
        "infoLink",
        "negate",
        "required",
        "fields",
        "presets"
})
@Generated("jsonschema2pojo")
 class Specification {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("implementation")
    private String implementation;
    @JsonProperty("implementationName")
    private String implementationName;
    @JsonProperty("infoLink")
    private String infoLink;
    @JsonProperty("negate")
    private Boolean negate;
    @JsonProperty("required")
    private Boolean required;
    @JsonProperty("fields")
    private List<Field> fields;
    @JsonProperty("presets")
    private List<String> presets;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("implementation")
    public String getImplementation() {
        return implementation;
    }

    @JsonProperty("implementation")
    public void setImplementation(String implementation) {
        this.implementation = implementation;
    }

    @JsonProperty("implementationName")
    public String getImplementationName() {
        return implementationName;
    }

    @JsonProperty("implementationName")
    public void setImplementationName(String implementationName) {
        this.implementationName = implementationName;
    }

    @JsonProperty("infoLink")
    public String getInfoLink() {
        return infoLink;
    }

    @JsonProperty("infoLink")
    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    @JsonProperty("negate")
    public Boolean getNegate() {
        return negate;
    }

    @JsonProperty("negate")
    public void setNegate(Boolean negate) {
        this.negate = negate;
    }

    @JsonProperty("required")
    public Boolean getRequired() {
        return required;
    }

    @JsonProperty("required")
    public void setRequired(Boolean required) {
        this.required = required;
    }

    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @JsonProperty("presets")
    public List<String> getPresets() {
        return presets;
    }

    @JsonProperty("presets")
    public void setPresets(List<String> presets) {
        this.presets = presets;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "movieMetadataId",
        "title",
        "cleanTitle",
        "overview",
        "language"
})
@Generated("jsonschema2pojo")
 class Translation {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("movieMetadataId")
    private Integer movieMetadataId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("cleanTitle")
    private String cleanTitle;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("language")
    private Language language;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("movieMetadataId")
    public Integer getMovieMetadataId() {
        return movieMetadataId;
    }

    @JsonProperty("movieMetadataId")
    public void setMovieMetadataId(Integer movieMetadataId) {
        this.movieMetadataId = movieMetadataId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("cleanTitle")
    public String getCleanTitle() {
        return cleanTitle;
    }

    @JsonProperty("cleanTitle")
    public void setCleanTitle(String cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("language")
    public Language getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(Language language) {
        this.language = language;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}