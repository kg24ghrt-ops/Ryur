package com.orchestrator.app;

import com.orchestrator.core.ZipExporter;

import java.io.File;

public class ZipHandler {

    public void zipFolder(File sourceDir, File zipFile) throws Exception {
        ZipExporter.exportProject(sourceDir, zipFile);
    }
}