package mx.edu.isc.tesoem.tsdem.examp2jags;

// ColorViewModel.java
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ColorViewModel extends ViewModel {
    private final MutableLiveData<Integer> colorMenu = new MutableLiveData<>();
    private final MutableLiveData<Integer> colorSuma = new MutableLiveData<>();
    private final MutableLiveData<Integer> colorResta = new MutableLiveData<>();

    public LiveData<Integer> getColorMenu() { return colorMenu; }
    public LiveData<Integer> getColorSuma() { return colorSuma; }
    public LiveData<Integer> getColorResta() { return colorResta; }

    public void setColorMenu(int color) { colorMenu.setValue(color); }
    public void setColorSuma(int color) { colorSuma.setValue(color); }
    public void setColorResta(int color) { colorResta.setValue(color); }
}
