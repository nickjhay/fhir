package org.hl7.fhir.igtools.publisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.dstu3.elementmodel.Element;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.model.ResourceType;
import org.hl7.fhir.dstu3.validation.ValidationMessage;

import com.google.gson.JsonObject;

public class FetchedFile {
  private String path;
  private String name;
  
  private byte[] source;
  private long hash;
  private long time;
  private String contentType;
  private List<FetchedFile> dependencies;
  private List<FetchedResource> resources = new ArrayList<FetchedResource>();
  private List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
  private Bundle bundle;
  
  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public long getTime() {
    return time;
  }
  public void setTime(long time) {
    this.time = time;
  }
  public String getContentType() {
    return contentType;
  }
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }
 
  public List<FetchedFile> getDependencies() {
    return dependencies;
  }
  public void setDependencies(List<FetchedFile> dependencies) {
    this.dependencies = dependencies;
  }
  public long getHash() {
    return hash;
  }
  public void setHash(long hash) {
    this.hash = hash;
  }
  public byte[] getSource() {
    if (source == null)
      throw new Error("Source has been dropped");
    return source;
  }
  public void setSource(byte[] source) {
    this.source = source;
    this.hash =Arrays.hashCode(source);
  }
  
  public void dropSource() {
    source = null;  
  }
  public List<FetchedResource> getResources() {
    return resources;
  }
  public FetchedResource addResource() {
    FetchedResource r = new FetchedResource();
    resources.add(r);
    return r;
  }
  public List<ValidationMessage> getErrors() {
    return errors;
  }
  public Bundle getBundle() {
    return bundle;
  }
  public void setBundle(Bundle bundle) {
    this.bundle = bundle;
  }
 
  
}