package hu.petrik.matrixoop;

import java.util.Random;

public class Matrix {
    private int sor;
    private int oszlop;
    private int[][] m;
    private static final Random rnd=new Random();

    public Matrix(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
        this.m=new int[sor][oszlop];
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                this.m[i][j]= rnd.nextInt(150)-50;
            }
        }
    }
    public int getElemekOsszege(){
        int osszeg=0;
        for (int[] sor:this.m) {
            for (int elem:sor) {
                osszeg+=elem;
            }
        }
        return osszeg;
    }
    public int getPozitivElemekSzama(){
        int db=0;
        for (int[] sor:this.m) {
            for (int elem:sor) {
                if (elem>0){
                    db++;
                }
            }
        }
        return db;
    }
    public int getLegnagyobbElem(){
        int max=this.m[0][0];
        for (int i = 0; i <this.m.length; i++) {
            for (int j = 0; j <this.m[i].length; j++) {
                if (max<this.m[i][j]){
                    max=this.m[i][j];
                }
            }
        }
        return max;
    }
    public int getElsoPozitivElem(){
        int sorindex=0;
        int oszlopindex=0;
        while (sorindex<this.m.length&&this.m[sorindex][oszlopindex]<1){
            oszlopindex=0;
            while (oszlopindex<this.m[sorindex].length&&this.m[sorindex][oszlopindex]<1){
                oszlopindex++;
            }
            sorindex++;
        }
        return this.m[sorindex][oszlopindex];
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (int[] sor:this.m) {
            for (int elem:sor) {
                sb.append(String.format("%3d ",elem));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
