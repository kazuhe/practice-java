package projava;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DiffSampleInherit {
    public static void main(String[] args) {
        var f = new JFrame("差分プログラミング");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var img = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        var g = img.createGraphics();
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, 600, 400);
        g.drawImage(lineImage(), 10, 10, f);
        g.drawImage(rectImage(), 300, 80, f);
        var label = new JLabel(new ImageIcon(img));
        f.add(label);
        f.pack();
        f.setVisible(true);
    }

    /**
     * 差分になる処理をメソッド draw として抜き出して継承して実装する
     * これは「テンプレートパターン」と呼ばれるデザインパターン
     * Gof のデザインパターン（継承の使い方を中心にクラスの設計手法をまとめたパターン集）とも呼ばれている
     */
    @FunctionalInterface
     interface ImageDrawer {
        default BufferedImage createImage() {
            var image = new BufferedImage(250, 200, BufferedImage.TYPE_INT_RGB);
            var graphics = image.createGraphics();
            draw(graphics);
            return image;
        }

        void draw(Graphics2D g);
    }

//    static class LineDrawer extends ImageDrawer {
//        @Override
//        void draw(Graphics2D g) {
//            g.drawLine(10, 10, 220, 180);
//        }
//    }

    static BufferedImage lineImage() {
//        return new LineDrawer().createImage();

        /*
          上記のコメントは ImageDrawer を継承しているが、
          他に利用しない場合は匿名クラスが利用できる
         */
//        return new ImageDrawer() {
//            @Override
//            public void draw(Graphics2D g) {
//                g.drawLine(10, 10, 220, 180);
//            }
//        }.createImage();

        /* 実装する必要のある抽象メソッドが 1 つだけなので匿名クラスをラムダ式に変更する */
        ImageDrawer drawer = g -> g.drawLine(10, 10, 220, 180);
        return drawer.createImage();
    }

    static class RectDrawer implements ImageDrawer {
        @Override
        public void draw(Graphics2D g) {
            g.drawRect(10, 10, 220, 180);
        }
    }

    static BufferedImage rectImage() {
        return new RectDrawer().createImage();
    }
}
