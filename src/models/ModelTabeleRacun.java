/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domen.Racun;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ookee
 */
public class ModelTabeleRacun extends AbstractTableModel {

    private ArrayList<Racun> listaRacuna;
    private String[] kolone = {"Vrsta računa"};

    public ModelTabeleRacun() {
        listaRacuna = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listaRacuna.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racun r = listaRacuna.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getRacun().getNaziv();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajRacun(Racun r) {
        listaRacuna.add(r);
        fireTableDataChanged();
    }

    public void obrisiRacun(Racun r) {
        listaRacuna.remove(r);
        fireTableDataChanged();
    }

    public ArrayList<Racun> getListaRacuna() {
        return listaRacuna;
    }

    public void setListaRacuna(ArrayList<Racun> listaRacuna) {
        this.listaRacuna = listaRacuna;
        fireTableDataChanged();
    }

}
