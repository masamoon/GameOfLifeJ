import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Andre on 18/02/2016.
 */
public class Main {



    public static void main(String[] args){
        Character[][] grid;
        Scanner sc = new Scanner(System.in);
        int height = 100;
        int width = 100;
        grid = new Character[height][width];

        int cells =1000;

        fill(grid);

        SecureRandom r = new SecureRandom();

        for(int i = 0; i< cells; i++) {
            int h = r.nextInt(100);
            int l = r.nextInt(100);

            grid[h][l] = 'x';
        }

        print(grid);

        while(true){
            int keyboard;
            keyboard = sc.nextInt();

            if(keyboard == 1){
                nextIter(grid);
                print(grid);

            }
        }

    }

    public static void fill(Character[][] grid){
       for(int i =0; i<grid.length ; i++)
           Arrays.fill(grid[i], '.');
    }

    public static void print(Character[][] grid){

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                if( j== grid.length-1)
                    System.out.println(grid[i][j]);
                else
                    System.out.print(grid[i][j]);

            }
        }
    }

    public static void nextIter(Character[][] grid){
        int neigh =0;

        for(int i=0; i<grid.length; i++){
            for( int j=0; j<grid.length; j++){
                if(grid[i][j].equals('x')) {
                    neigh = numneigh(grid, i, j, grid[i].length-1);
                    decisionLive(grid,neigh,i,j);
                }
                if(grid[i][j].equals('.')){
                    neigh = numneigh(grid,i,j, grid[j].length-1);
                    decisionDead(grid,neigh,i,j);
                }
            }
        }
    }

    public static void decisionLive(Character[][] grid, int numneigh, int i, int j){
        if(numneigh < 2 || numneigh > 3)
            grid[i][j] = '.';

    }

    public static void decisionDead(Character[][] grid, int numneigh, int i, int j){
        if(numneigh == 3)
            grid[i][j] = 'x';
    }


    public static int numneigh(Character[][] grid, int i, int j, int len) {

        int neighbors = 0;
        //int len = 99;


        //System.out.println("neighbors on "+ i +" e "+j);
        if(i < len) {
            if (grid[i + 1][j].equals('x'))
                neighbors++;
        }

        if(j < len) {
            if (grid[i][j + 1].equals('x'))
                neighbors++;
        }

        if(i < len && j < len) {
            if (grid[i + 1][j + 1].equals('x'))
                neighbors++;
        }
        if (i > 0) {
            if (grid[i - 1][j].equals('x'))
                neighbors++;
        }
        if (j > 0){
            if (grid[i][j - 1].equals('x'))
                neighbors++;
        }
        if(i > 0 && j> 0) {
            if (grid[i - 1][j - 1].equals('x'))
                neighbors++;
        }
        return neighbors;

        }





    }



