package com.orchestrator.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.orchestrator.core.TaskManager;
import com.orchestrator.core.WorkspaceManager;
import com.orchestrator.core.ZipExporter;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private TextView txtLogs;
    private Button btnNewProject;
    private Button btnOpenAI;
    private Button btnPackage;

    private ProjectManager projectManager;
    private BrowserAIManager browserAIManager;
    private ZipHandler zipHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogs = findViewById(R.id.txtLogs);
        btnNewProject = findViewById(R.id.btnNewProject);
        btnOpenAI = findViewById(R.id.btnOpenAI);
        btnPackage = findViewById(R.id.btnPackage);

        projectManager = new ProjectManager(this, "MyAIProject");
        browserAIManager = new BrowserAIManager(this);
        zipHandler = new ZipHandler();

        btnNewProject.setOnClickListener(v -> {
            txtLogs.append("Creating new workspace...\n");
            File workspace = projectManager.createWorkspace("Workspace1");
            WorkspaceManager.init(workspace); // initialize workspace via library
            txtLogs.append("Workspace initialized: " + workspace.getAbsolutePath() + "\n");
        });

        btnOpenAI.setOnClickListener(v -> {
            txtLogs.append("Opening ChatGPT AI...\n");
            browserAIManager.openAI("ChatGPT");
        });

        btnPackage.setOnClickListener(v -> {
            txtLogs.append("Packaging project...\n");
            File zipFile = new File(getFilesDir(), "MyAIProject.zip");
            try {
                ZipExporter.exportProject(new File(getFilesDir(), "MyAIProject"), zipFile); // library method
                txtLogs.append("Project packaged at: " + zipFile.getAbsolutePath() + "\n");
            } catch (Exception e) {
                txtLogs.append("Error packaging project: " + e.getMessage() + "\n");
            }
        });
    }
}