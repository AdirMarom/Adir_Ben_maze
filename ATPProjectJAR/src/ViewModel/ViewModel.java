package ViewModel;

import Model.IModel;
import Model.Model;
import algorithms.search.Solution;
import javafx.scene.input.KeyCode;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {

    private IModel model;

    public ViewModel(IModel model){
        this.model = model;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o==model){
            setChanged();
            notifyObservers();
        }
    }

    public Solution getSolution(){return this.model.GenerateSolution();}

    public void generateSolution(){this.model.GenerateSolution();}

    public void generateMaze(int row ,int col){this.model.GenerateMaze(row,col);}

    public int[][] getMaze(){return model.getMaze();}

    public algorithms.mazeGenerators.Maze getMazeObj(){return this.model.getMazeObj();}

    public void moveCharacter(KeyCode movement) {model.moveCharacter(movement);}

    public int getCharacterPositionRow() {return this.model.getCharacterPositionRow();}

    public int getCharacterPositionColumn() {return this.model.getCharacterPositionCol();}

    public int get_Start_Row_Pos() {
        return this.model.get_Start_Row_Pos();
    }

    public int get_End_Row_Pos() {
        return this.model.get_End_Row_Pos();
    }

    public int get_Start_Col_Pos() {
        return this.model.get_Start_Col_Pos();
    }

    public int get_End_Col_Pos() {
        return this.model.get_End_Col_Pos();
    }

    public void SaveMaze(File f){this.model.SaveMaze(f);}

    public void loadMaze(File f) { this.model.loadMaze(f); }
}
