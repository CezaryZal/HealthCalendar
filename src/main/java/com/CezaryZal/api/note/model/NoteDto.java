package com.CezaryZal.api.note.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class NoteDto{

    private Long id;
    private String header;
    private String detailsNote;
    private Long dayId;


    public static final class Builder{
        private Long id;
        private String header;
        private String detailsNote;
        private Long dayId;

        public static Builder builder(){
            return new Builder();
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder header(String header){
            this.header = header;
            return this;
        }
        public Builder details(String detailsNote){
            this.detailsNote = detailsNote;
            return this;
        }
        public Builder dayId(Long dayId){
            this.dayId = dayId;
            return this;
        }

        public NoteDto build(){
            NoteDto formNote = new NoteDto();
            formNote.id = this.id;
            formNote.header = this.header;
            formNote.detailsNote = this.detailsNote;
            formNote.dayId = this.dayId;
            return formNote;
        }
    }
}
