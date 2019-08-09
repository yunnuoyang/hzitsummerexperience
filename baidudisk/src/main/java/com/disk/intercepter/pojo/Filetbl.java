package com.disk.intercepter.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Filetbl {
    private int fileId;
    private String filename;
    private Timestamp uploadDate;
    private String downcode;
    private String filepath;
    private String sortname;
    private Netuser netuserByUsername;
    private Filesort filesortBySortid;

    @Id
    @Column(name = "fileId", nullable = false)
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "filename", nullable = true, length = 50)
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    @Basic
    @Column(name = "uploadDate", nullable = true)
    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Basic
    @Column(name = "downcode", nullable = true, length = 32)
    public String getDowncode() {
        return downcode;
    }

    public void setDowncode(String downcode) {
        this.downcode = downcode;
    }

    @Basic
    @Column(name = "filepath", nullable = true, length = 150)
    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }


    @Basic
    @Column(name = "sortname", nullable = true, length = 100)
    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }





    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    public Netuser getNetuserByUsername() {
        return netuserByUsername;
    }

    public void setNetuserByUsername(Netuser netuserByUsername) {
        this.netuserByUsername = netuserByUsername;
    }

    @ManyToOne
    @JoinColumn(name = "sortid", referencedColumnName = "sortid")
    public Filesort getFilesortBySortid() {
        return filesortBySortid;
    }

    public void setFilesortBySortid(Filesort filesortBySortid) {
        this.filesortBySortid = filesortBySortid;
    }
}
