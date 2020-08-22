package uz.crm.system.entity.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

/** Для хранение данных о файлах а именно тип файла и его размер, сам файл будет храниться в "AttachmentContent" **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment extends AbsEntity {

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private Long size;

}
