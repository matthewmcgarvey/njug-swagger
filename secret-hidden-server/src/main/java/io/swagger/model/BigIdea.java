package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BigIdea
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-03T14:05:28.679-06:00")

public class BigIdea   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("details")
  private String details = null;

  @JsonProperty("rating")
  private Integer rating = null;

  public BigIdea name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigIdea id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * minimum: 1
   * @return id
  **/
  @ApiModelProperty(readOnly = true, value = "")

@Min(1)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigIdea details(String details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   * @return details
  **/
  @ApiModelProperty(value = "")


  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public BigIdea rating(Integer rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Get rating
   * minimum: 1
   * maximum: 10
   * @return rating
  **/
  @ApiModelProperty(value = "")

@Min(1) @Max(10) 
  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BigIdea bigIdea = (BigIdea) o;
    return Objects.equals(this.name, bigIdea.name) &&
        Objects.equals(this.id, bigIdea.id) &&
        Objects.equals(this.details, bigIdea.details) &&
        Objects.equals(this.rating, bigIdea.rating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, details, rating);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BigIdea {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

