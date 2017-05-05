// Copyright (c) 2016, NanoString Technologies, Inc.  All rights reserved.
// Use of this file for any purpose requires prior written consent of NanoString Technologies, Inc.

package com.infoclinika.mssharing.web.controller.request;

/**
 * @author Yevhen Panko (yevhen.panko@teamdev.com)
 */
public class FilesReadyToUploadRequest {
    public long instrumentId;
    public FileDescription[] fileDescriptions;

    public FilesReadyToUploadRequest() {
    }
}