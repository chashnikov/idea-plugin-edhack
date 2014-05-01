package org.edhack;

import com.intellij.ide.impl.ProjectUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.io.StreamUtil;
import com.intellij.util.io.ZipUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author nik
 */
public class StartLearningAction extends AnAction {
  public void actionPerformed(AnActionEvent e) {
    PluginSettings settings = PluginSettings.getSettings(getEventProject(e));
    String myUrl = settings.myUrl;
    try {
      File zipFile = FileUtil.createTempFile("projectArchive", null, true);
      InputStream input = getClass().getResourceAsStream("/helloProject.zip");
      FileUtil.writeToFile(zipFile, StreamUtil.loadFromStream(input));

      File dir = FileUtil.createTempDirectory("learningProject", null);
      ZipUtil.extract(zipFile, dir, null);
      File projectRoot = new File(dir, "helloProject");

      ProjectUtil.openOrImport(projectRoot.getAbsolutePath(), null, false);
    } catch (IOException e1) {
      Messages.showErrorDialog(e1.getMessage(), "Plugin Message");
    }


  }
}
