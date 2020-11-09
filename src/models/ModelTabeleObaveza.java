/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domen.Obaveza;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ookee
 */
public class ModelTabeleObaveza extends AbstractTableModel {

    private ArrayList<Obaveza> listaObaveza;
    private String[] kolone = {"Broj resenja", "Ukupni iznos", "Datum kreiranja"};

    public ModelTabeleObaveza() {
        listaObaveza = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listaObaveza.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Obaveza o = listaObaveza.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getBrResenja();
            case 1:
                return o.getUkupniIznos();
            case 2:
                return o.getDatumKreiranja();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajObavezu(Obaveza o) {
        listaObaveza.add(o);
        fireTableDataChanged();
    }

    public void obrisiObavezu(Obaveza o) {
        listaObaveza.remove(o);
        fireTableDataChanged();
    }

    public ArrayList<Obaveza> getListaObaveza() {
        return listaObaveza;
    }

    public void setListaObaveza(ArrayList<Obaveza> listaObaveza) {
        this.listaObaveza = listaObaveza;
        fireTableDataChanged();
    }

}
