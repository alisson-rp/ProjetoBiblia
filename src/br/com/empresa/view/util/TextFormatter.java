package br.com.empresa.view.util;

import java.awt.Color;
import java.awt.Font;

public class TextFormatter {
    private String titulo;
	private String text;
    private int size;
    private String fontName;
    private Color color;
    private boolean centerAlign;
    private int sizetext;
    private String fontNametext;
    private Color colortext;
    private boolean centerAligntext;

    public TextFormatter(String titulo, String text) {
        
    	this.titulo = titulo;
    	this.text = text;
        this.size = 8;
        this.fontName = "Tahoma";
        this.color = Color.BLUE;
        this.centerAlign = true;
        this.sizetext = 5;
        this.fontNametext = "Tahoma";
        this.colortext = Color.BLACK;
        this.centerAligntext = true;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCenterAlign(boolean centerAlign) {
        this.centerAlign = centerAlign;
    }
    
	public int getSizetext() {
		return sizetext;
	}

	public void setSizetext(int sizetext) {
		this.sizetext = sizetext;
	}

	public String getFontNametext() {
		return fontNametext;
	}

	public void setFontNametext(String fontNametext) {
		this.fontNametext = fontNametext;
	}

	public Color getColortext() {
		return colortext;
	}

	public void setColortext(Color colortext) {
		this.colortext = colortext;
	}

	public boolean isCenterAligntext() {
		return centerAligntext;
	}

	public void setCenterAligntext(boolean centerAligntext) {
		this.centerAligntext = centerAligntext;
	}

	public String format() {
        StringBuilder formattedText = new StringBuilder();

        if (centerAlign) {
            formattedText.append("<html><div align='center'>");
        } else {
            formattedText.append("<html>");
        }

        formattedText.append("<div><font size='")
		        .append(size)
		        .append("' face='")
		        .append(fontName)
		        .append("' color='")
		        .append(getColorHexValue(color))
		        .append("'>")
		        .append("<br>")
		        .append("<strong>")
		        .append(titulo)
		        .append("</strong>")
		        .append("</font></div>")
		        .append("<hr>")
		        .append("<br>")
        		.append("<font size='")
                .append(sizetext)
                .append("' face='")
                .append(fontNametext)
                .append("' color='")
                .append(getColorHexValue(colortext))
                .append("'>")
                .append(text)
                .append("</font></html>");

        return formattedText.toString();
    }

    private String getColorHexValue(Color color) {
        return String.format("#%06X", (0xFFFFFF & color.getRGB()));
    }

}

