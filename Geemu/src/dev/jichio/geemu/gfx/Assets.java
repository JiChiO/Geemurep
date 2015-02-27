package dev.jichio.geemu.gfx;

import dev.jichio.geemu.text.TextLoader;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Assets {



    public static BufferedImage player;

    public static void init(){
        BufferedImage b [] = ArrayCrop("/textures/GGs", "png");
        //Присваиваем атрибуту player парядковый номер спрайтшита из списка
        player = b[1];
    }
    //Рабивеам спрайты на массивы
    public static BufferedImage[] ArrayCrop(String s, String res){
        //Загружаем картинку в формате s=имя + res=расширение
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(s + "." + res));
        //Загружаем размеры нарезки и общее спрайтов из текстового файла
        String q[] = TextLoader.loadText(s + ".txt");
        //Создаем список спрайтов
        List<BufferedImage> list = new ArrayList<BufferedImage>();
        // Присваиваем по порядку ширину, длину и кол-во спрайтов из файла
        int charwidth = Integer.parseInt(q[0]);
        int charheight = Integer.parseInt(q[1]);
        int charcount = Integer.parseInt(q[2]);
        //Заполняем масив изображенями делая обходя по строкам
        for (int i = 0; (i < sheet.height()/charheight) && (charcount != 0); i++) {
            for (int j = 0; (j < sheet.widht()/charwidth) && (charcount != 0); j++) {
                //Добовляем в список вырезаные спрайтшиты
                list.add(sheet.crop(j * charwidth, i * charheight, charwidth, charheight));
                //Обратный отсчет кол-ва спрайтшитов
                charcount = charcount - 1;
            }
        }
        //Возвращаем массив преобразоный из списка
        return list.toArray(new BufferedImage[0]);
    }
}
