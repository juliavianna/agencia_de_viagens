public class Frequencia {
     String frequenciaDoVoo;

     public Frequencia(){
          frequenciaDoVoo = "";
     }

     public void setFrequencia(char valor) {
          if(valor == '1'){
               frequenciaDoVoo += "Domingo";
          }
          if(valor == '2'){
               frequenciaDoVoo += ", Segunda";
          }
          if(valor == '3'){
               frequenciaDoVoo += ", Terca";
          }
          if(valor == '4'){
               frequenciaDoVoo += ", Quarta";
          }
          if(valor == '5'){
               frequenciaDoVoo += ", Quinta";
          }
          if(valor == '6'){
               frequenciaDoVoo += ", Sexta";
          }
          if(valor == '7'){
               frequenciaDoVoo += ", Sabado";
          }
     }

     public String mostrarFrequencia(){
         return frequenciaDoVoo;
     }
 }
 