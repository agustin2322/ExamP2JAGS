package mx.edu.isc.tesoem.tsdem.examp2jags;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {

    private TextView tvHistorial;
    private List<OperacionData> historialOperaciones = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        tvHistorial = rootView.findViewById(R.id.tvHistorial);

        // Configurar botones para cambiar colores (código previo)
        // ...

        // Verificar si hay datos de operaciones para mostrar
        if (getArguments() != null) {
            OperacionData operacion = getArguments().getParcelable(SumaFragment.KEY_OPERACION);
            if (operacion == null) {
                operacion = getArguments().getParcelable(RestaFragment.KEY_OPERACION);
            }

            if (operacion != null) {
                historialOperaciones.add(operacion);
                actualizarHistorial();
            }
        }

        return rootView;
    }

    private void actualizarHistorial() {
        StringBuilder sb = new StringBuilder();
        sb.append("Historial de operaciones:\n");

        for (OperacionData op : historialOperaciones) {
            sb.append(op.getTipoOperacion())
                    .append(": ")
                    .append(op.getNumero1())
                    .append(op.getTipoOperacion().equals("Suma") ? " + " : " - ")
                    .append(op.getNumero2())
                    .append(" = ")
                    .append(op.getResultado())
                    .append("\n");
        }

        tvHistorial.setText(sb.toString());
    }
}