package mx.edu.isc.tesoem.tsdem.examp2jags;

import android.os.Parcel;
import android.os.Parcelable;

public class OperacionData implements Parcelable {
    private double numero1;
    private double numero2;
    private double resultado;
    private String tipoOperacion;

    public OperacionData(double numero1, double numero2, String tipoOperacion) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.tipoOperacion = tipoOperacion;
    }

    protected OperacionData(Parcel in) {
        numero1 = in.readDouble();
        numero2 = in.readDouble();
        resultado = in.readDouble();
        tipoOperacion = in.readString();
    }

    public static final Creator<OperacionData> CREATOR = new Creator<OperacionData>() {
        @Override
        public OperacionData createFromParcel(Parcel in) {
            return new OperacionData(in);
        }

        @Override
        public OperacionData[] newArray(int size) {
            return new OperacionData[size];
        }
    };

    // Getters y setters
    public double getNumero1() { return numero1; }
    public double getNumero2() { return numero2; }
    public double getResultado() { return resultado; }
    public String getTipoOperacion() { return tipoOperacion; }
    public void setResultado(double resultado) { this.resultado = resultado; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(numero1);
        dest.writeDouble(numero2);
        dest.writeDouble(resultado);
        dest.writeString(tipoOperacion);
    }
}
