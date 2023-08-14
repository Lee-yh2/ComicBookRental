package com.cmbookrental.prj.dto;

import lombok.Getter;

@Getter
public class ComicBookDto {
    private int bookNo;
    private String title;
    private String writerName;

    public ComicBookDto(int bookNo, String title, String writerName) {
        this.bookNo = bookNo;
        this.title = title;
        this.writerName = writerName;
    }

    @Override
    public String toString() {
        return "만화책ID :" + this.bookNo + "\n" +
                "만화책 이름 : " + this.title + "\n" +
                "작가 이름 : " + this.writerName;
    }
}
