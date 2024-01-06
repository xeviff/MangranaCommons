
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
import tv.mangrana.radarr.api.schema.queue.Quality__1;
import tv.mangrana.sonarr.api.schema.history.Revision;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "movieId",
        "relativePath",
        "path",
        "size",
        "dateAdded",
        "indexerFlags",
        "quality",
        "customFormats",
        "qualityCutoffNotMet",
        "languages",
        "edition",
        "id"
})
@Generated("jsonschema2pojo")
public class MovieFile {

    @JsonProperty("movieId")
    private Integer movieId;
    @JsonProperty("relativePath")
    private String relativePath;
    @JsonProperty("path")
    private String path;
    @JsonProperty("size")
    private Long size;
    @JsonProperty("dateAdded")
    private String dateAdded;
    @JsonProperty("indexerFlags")
    private Integer indexerFlags;
    @JsonProperty("quality")
    private Quality quality;
    @JsonProperty("customFormats")
    private List<Object> customFormats;
    @JsonProperty("qualityCutoffNotMet")
    private Boolean qualityCutoffNotMet;
    @JsonProperty("languages")
    private List<Language> languages;
    @JsonProperty("edition")
    private String edition;
    @JsonProperty("id")
    private Integer id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("movieId")
    public Integer getMovieId() {
        return movieId;
    }

    @JsonProperty("movieId")
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @JsonProperty("relativePath")
    public String getRelativePath() {
        return relativePath;
    }

    @JsonProperty("relativePath")
    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("size")
    public Long getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Long size) {
        this.size = size;
    }

    @JsonProperty("dateAdded")
    public String getDateAdded() {
        return dateAdded;
    }

    @JsonProperty("dateAdded")
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @JsonProperty("indexerFlags")
    public Integer getIndexerFlags() {
        return indexerFlags;
    }

    @JsonProperty("indexerFlags")
    public void setIndexerFlags(Integer indexerFlags) {
        this.indexerFlags = indexerFlags;
    }

    @JsonProperty("quality")
    public Quality getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    @JsonProperty("customFormats")
    public List<Object> getCustomFormats() {
        return customFormats;
    }

    @JsonProperty("customFormats")
    public void setCustomFormats(List<Object> customFormats) {
        this.customFormats = customFormats;
    }

    @JsonProperty("qualityCutoffNotMet")
    public Boolean getQualityCutoffNotMet() {
        return qualityCutoffNotMet;
    }

    @JsonProperty("qualityCutoffNotMet")
    public void setQualityCutoffNotMet(Boolean qualityCutoffNotMet) {
        this.qualityCutoffNotMet = qualityCutoffNotMet;
    }

    @JsonProperty("languages")
    public List<Language> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    @JsonProperty("edition")
    public String getEdition() {
        return edition;
    }

    @JsonProperty("edition")
    public void setEdition(String edition) {
        this.edition = edition;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
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
        "quality",
        "revision"
})
@Generated("jsonschema2pojo")
class Quality {

    @JsonProperty("quality")
    private Quality__1 quality;
    @JsonProperty("revision")
    private Revision revision;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("quality")
    public Quality__1 getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(Quality__1 quality) {
        this.quality = quality;
    }

    @JsonProperty("revision")
    public Revision getRevision() {
        return revision;
    }

    @JsonProperty("revision")
    public void setRevision(Revision revision) {
        this.revision = revision;
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