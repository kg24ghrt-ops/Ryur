package com.orchestrator.app;

import android.content.Context;
import android.util.Log;

import com.orchestrator.core.WorkspaceManager;
import com.orchestrator.core.TaskManager;

import java.io.File;

public class ProjectManager {

    private final Context context;
    private final File projectRoot;

    public ProjectManager(Context context, String projectName) {
        this.context = context;
        projectRoot = new File(context.getFilesDir(), projectName);
        if (!projectRoot.exists()) projectRoot.mkdirs();
    }

    public File createWorkspace(String workspaceName) {
        File workspace = new File(projectRoot, workspaceName);
        if (!workspace.exists()) workspace.mkdirs();

        // Initialize library workspace
        WorkspaceManager.init(workspace);

        Log.d("ProjectManager", "Workspace created: " + workspace.getAbsolutePath());
        return workspace;
    }

    public void runTask(File workspace, String taskName, String input) {
        TaskManager.run(workspace, taskName, input);
    }

    public String getWorkspaceLogs(File workspace) {
        return TaskManager.getLogs(workspace);
    }
}