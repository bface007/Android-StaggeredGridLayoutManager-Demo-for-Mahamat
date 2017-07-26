package com.bfacedemo.demopourmahamat.models;

/**
 * Created by bface007 on 26/07/2017.
 */

public class Recipe {
  protected String name;
  protected String description;
  protected int cover;
  protected long time;

  public Recipe() {}

  public Recipe(String name, String description, int cover, long time) {
    this.name = name;
    this.description = description;
    this.cover = cover;
    this.time = time;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getCover() {
    return cover;
  }

  public void setCover(int cover) {
    this.cover = cover;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }
}
