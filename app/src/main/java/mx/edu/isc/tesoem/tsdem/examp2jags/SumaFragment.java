package mx.edu.isc.tesoem.tsdem.examp2jags;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SumaFragment extends Fragment {

    public static final String KEY_OPERACION = "operacion_data";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_suma, container, false);

        Button btnCalcular = rootView.findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(v -> {
            calcularSuma(rootView);

            // Guardar la operación en el Bundle
            if (getArguments() == null) {
                setArguments(new Bundle());
            }

            EditText etNum1 = rootView.findViewById(R.id.etNum1);
            EditText etNum2 = rootView.findViewById(R.id.etNum2);
            TextView tvResultado = rootView.findViewById(R.id.tvResultado);

            try {
                double num1 = Double.parseDouble(etNum1.getText().toString());
                double num2 = Double.parseDouble(etNum2.getText().toString());
                double resultado = num1 + num2;

                OperacionData operacion = new OperacionData(num1, num2, "Suma");
                operacion.setResultado(resultado);

                getArguments().putParcelable(KEY_OPERACION, operacion);
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Ingrese números válidos", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void calcularSuma(View rootView) {
        EditText etNum1 = rootView.findViewById(R.id.etNum1);
        EditText etNum2 = rootView.findViewById(R.id.etNum2);
        TextView tvResultado = rootView.findViewById(R.id.tvResultado);

        try {
            double num1 = Double.parseDouble(etNum1.getText().toString());
            double num2 = Double.parseDouble(etNum2.getText().toString());
            double resultado = num1 + num2;
            tvResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Ingrese números válidos", Toast.LENGTH_SHORT).show();
        }
    }
}