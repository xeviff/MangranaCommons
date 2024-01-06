package tv.mangrana.radarr.api.schema.movie;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ignoreEpisodesWithFiles",
        "ignoreEpisodesWithoutFiles",
        "monitor",
        "searchForMovie",
        "addMethod"
})
@Generated("jsonschema2pojo")
public class AddOptions {

    @JsonProperty("ignoreEpisodesWithFiles")
    private Boolean ignoreEpisodesWithFiles;
    @JsonProperty("ignoreEpisodesWithoutFiles")
    private Boolean ignoreEpisodesWithoutFiles;
    @JsonProperty("monitor")
    private String monitor;
    @JsonProperty("searchForMovie")
    private Boolean searchForMovie;
    @JsonProperty("addMethod")
    private String addMethod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("ignoreEpisodesWithFiles")
    public Boolean getIgnoreEpisodesWithFiles() {
        return ignoreEpisodesWithFiles;
    }

    @JsonProperty("ignoreEpisodesWithFiles")
    public void setIgnoreEpisodesWithFiles(Boolean ignoreEpisodesWithFiles) {
        this.ignoreEpisodesWithFiles = ignoreEpisodesWithFiles;
    }

    @JsonProperty("ignoreEpisodesWithoutFiles")
    public Boolean getIgnoreEpisodesWithoutFiles() {
        return ignoreEpisodesWithoutFiles;
    }

    @JsonProperty("ignoreEpisodesWithoutFiles")
    public void setIgnoreEpisodesWithoutFiles(Boolean ignoreEpisodesWithoutFiles) {
        this.ignoreEpisodesWithoutFiles = ignoreEpisodesWithoutFiles;
    }

    @JsonProperty("monitor")
    public String getMonitor() {
        return monitor;
    }

    @JsonProperty("monitor")
    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    @JsonProperty("searchForMovie")
    public Boolean getSearchForMovie() {
        return searchForMovie;
    }

    @JsonProperty("searchForMovie")
    public void setSearchForMovie(Boolean searchForMovie) {
        this.searchForMovie = searchForMovie;
    }

    @JsonProperty("addMethod")
    public String getAddMethod() {
        return addMethod;
    }

    @JsonProperty("addMethod")
    public void setAddMethod(String addMethod) {
        this.addMethod = addMethod;
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
