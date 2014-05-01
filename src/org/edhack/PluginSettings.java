package org.edhack;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author nik
 */
@State(name = "PluginSettings",storages = {
    @Storage(file = StoragePathMacros.PROJECT_FILE)
})
public class PluginSettings implements ProjectComponent, PersistentStateComponent<PluginSettings> {
  public String myUrl = "http://my-server";

  public PluginSettings() {
  }

  @Nullable
  @Override
  public PluginSettings getState() {
    return this;
  }

  @Override
  public void loadState(PluginSettings state) {
    XmlSerializerUtil.copyBean(state, this);
  }

  public PluginSettings(Project project) {
  }

  public static PluginSettings getSettings(Project project) {
    return project.getComponent(PluginSettings.class);
  }

  public void initComponent() {
  }

  public void disposeComponent() {
  }

  @NotNull
  public String getComponentName() {
    return "PluginSettings";
  }

  public void projectOpened() {
    // called when project is opened
  }

  public void projectClosed() {
    // called when project is being closed
  }
}
