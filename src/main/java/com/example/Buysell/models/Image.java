package com.example.Buysell.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity   //говорит, что класс представляет таблицу в базе данных
@Table(name="images")           //настройка имени таблицы в базе
@Data     //для автоматической генерации шаблонного кода (геттеры, сеттеры, конструкторы и др методы)
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id            //первичный ключ
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="originalFileName")
    private String originalFileName;
    @Column(name="size")
    private Long size;
    @Column(name="contentType")
    private String contentType; //расширение файла
    @Column(name="isPreviewImage")
    private boolean isPreviewImage; 
    @Lob     //в базе данных переменная будет храниться в типе LONGBLOB
    private byte[] bytes;

    //связь многие к одному, как повлияет удаление картинки на товар(обновится), способ загрузки сущностей к данной
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product; //вместо товара будет его id
}
