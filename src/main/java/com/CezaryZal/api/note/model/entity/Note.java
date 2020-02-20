package com.CezaryZal.api.note.model.entity;

import com.CezaryZal.api.note.model.Header;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "note")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(
        name="ResultInHeader",
        classes = {
                @ConstructorResult(
                        targetClass = Header.class,
                        columns = {
                                @ColumnResult(name="id", type = Long.class),
                                @ColumnResult(name="header", type = String.class)

                        })
        })
@NamedNativeQuery(
        name = "Result",
        query = "SELECT n.id, n.header FROM note AS n WHERE n.day_id=:dayId",
        resultSetMapping = "ResultInHeader"
)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "header")
    private String header;

    @Column(name = "details_note")
    private String detailsNote;

    @Column(name = "day_id")
    private Long dayId;


    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String header;
        private String detailsNote;
        private Long dayId;

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

        public Note build(){
            Note note = new Note();
            note.id = this.id;
            note.header = this.header;
            note.detailsNote = this.detailsNote;
            note.dayId = this.dayId;
            return note;
        }
    }
}
