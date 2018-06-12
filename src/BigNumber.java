public class BigNumber {
    String num;

    // Constructor 1
    public BigNumber(String s) {

        StringBuilder sb = new StringBuilder();
        //Si el String rebut es un unic cero, simplement l'afegim com ens ve.
        if (s.equals("0")){
            this.num = s;
            //Si no es un numero negatiu.
        } else if (s.charAt(0) != '-') {

            //Amb aquest bucle contem quants de 0 té al principi, en cas que tingui per a poder eliminar-los.
            int cont = 0;
            while (s.charAt(cont) == 48) {
                //En cas que el comptador de 0 arribi a ser d'igual llargària que el string rebut,
                // significarà que el string són només molt de 0, per el qual simplement el deixem com a valor i trenquem el bucle
                if (cont == s.length() -1){
                    this.num = s;
                    break;
                }
                cont++;
            }
            //En aquest pas copiam el string rebut en un StringBuilder contant a partir del comptador del bucle anterior
            //així els zeros del principi no seran al string final
            for (int i = cont; i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
            this.num = sb.toString();

        }
        //En cas de número negatiu simplement fem servir la mateixa metodologia amb la diferència que abans de guardar al StringBuilder el resultat posam el signe -.
        else{
            int cont = 1;
            sb.append(s.charAt(0));
            while (s.charAt(cont) == '0') {
                cont++;
            }
            for (int i = cont; i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
            this.num = sb.toString();
        }
    }

    // Constructor 2, aquest es simplement un constructor de copia
    public BigNumber(BigNumber b) {
        this.num = b.num;
    }

    // Suma
    BigNumber add(BigNumber other) {
        String x;
        int need;
        int resta = 0;
        StringBuilder big = new StringBuilder();
        //En aquest pas comprovam quin es el numero més curt dels dos i calculam la diferència de llargària.
        if (this.num.length() >= other.num.length()){
            need = this.num.length() - other.num.length();
            x = other.num;
            big.append(this.num);
        } else{
            need = other.num.length() - this.num.length();
            x = this.num;
            big.append(other.num);
        }

        //Al menor, afegim 0 al principi,tants com indici la variable need i despres afegim el string mes curt.
        StringBuilder small = new StringBuilder();
        for (int i = 0; i < need; i++) {
            small.append("0");
        }
        small.append(x);

        //Giram ambdos numeros
        big = big.reverse();
        small = small.reverse();

        //Per a obtenir el resultat sumam els numeros de digit a digit
        //i anam guardant el resultat de cada suma dins un StringBuilder,
        //una vegada obtingut el resultat final,el giram i el retornam.
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= big.length(); i++) {
            if (i == big.length()){ res.append(resta); break;}
            //En cas de que el numero que toqui executar sigui un '-' simplement el posam al resultat final y trencam el bucle.
            if (big.charAt(i) == '-'){res.append("-"); break;}
            int conta = (big.charAt(i) - 48) + (small.charAt(i) - 48);

            if (conta + resta >= 10){
                res.append((conta + resta) % 10);
                resta = 1;
            }else{
                res.append(conta + resta);
                resta = 0;
            }
        }
        String y = res.reverse().toString();
        return new BigNumber(y);
    }
    // Resta
    BigNumber sub(BigNumber other) {

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int resta = 0;
        int need;

        if (this.compareTo(other) == 0){
            return new BigNumber("0");
        //En cas de que el primer numero sigui major al segon.
        }else if (this.compareTo(other) == 1){

            //Contam la diferencia en numero de digits entre ambdos y afegim 0 al principi del segon numero per a igualarlos en tamany.
            need = this.num.length() - other.num.length();
            for (int i = 0; i < need; i++) {
                second.append("0");
            }
            //giram ambdos numeros.
            second.append(other.num).reverse();
            first.append(this.num).reverse();

        //En cas de que el primer numero sigui menor al segon seguim la mateixa metodologia simplement afegint els 0 al primer numero i afegint un - al resultat.
        } else if (this.compareTo(other) == -1){
            need = other.num.length() - this.num.length();
            for (int i = 0; i < need; i++) {
                first.append("0");
            }
            second.append(other.num).reverse();
            first.append(this.num).reverse();
        }
        //Efectuam les contes digit a digit i una vegada acabat,per a retornar el valor el giram primer.
        for (int i = 0; i < first.length(); i++) {
            int conta = ((first.charAt(i) - 48) - resta) - (second.charAt(i) - 48);
            if (conta < 0){
                if (i == first.length() -1){
                    res.append(conta * -1);
                } else {
                    conta += 10;
                    resta = 1;
                    res.append(conta);
                }
            } else{
                res.append(conta);
                resta = 0;
            }
        }
        if (this.compareTo(other) == -1){
            res.append("-");
        }
        return new BigNumber(res.reverse().toString());


    }
    // Multiplica
    BigNumber mult(BigNumber other) {

        //Primer cream un BigNumber amb valor 0, aqui anirem acumulant el resultat de les multiplicacions.
        BigNumber result = new BigNumber("0");
        int counter = 0;
        int t = 0;

        //Aquest bucle s'executa tantes vegades com digits tengui el segon numero.
        for (int i = other.num.length(); i > 0 ; i--, t++) {

            //Guardam el digit en execució.
            int x = other.num.charAt(i -1) -48;
            StringBuilder y = new StringBuilder();
            //Aquest bucle s'executara tantes vegades com dígits tingui el primer número.
            //Simplement multiplicam el número x per cada un dels números del primer número
            // una vegada multiplicat es guarda aquest resultat a un String i es suma al BigNumber resultat.
            for (int j = this.num.length(); j > 0; j--) {

                int z = this.num.charAt(j-1)-48;

                int conta = (z * x) + counter;
                if (conta >= 10){
                    counter = conta / 10;
                    conta = conta % 10;
                    y.append(conta);
                } else{
                    y.append(conta);
                    counter = 0;
                }
            }
            y.append(counter);
            counter = 0;
            y = y.reverse();
            //En aquest pas afegim 0 al resultat per a emular el corriment lateral que hem de fer a l'hora de multiplicar a ma.
            if (t > 0){
                for (int e = 0; e < t; e++) {
                    y.append("0");
                }
            }
            result = result.add(new BigNumber(y.toString()));
        }
        return result;
    }

    // Divideix
    BigNumber div(BigNumber other) {

        //mentres el BigNumber x sigui major que el BigNNumber rebut
        //a x li restarem el valor de other i incrementarem y, que sira el resultat final.

        BigNumber x = new BigNumber(this);
        BigNumber y = new BigNumber("0");
        BigNumber z = new BigNumber("1");

        while (x.compareTo(other) == 1){
            x = x.sub(other);
            y = y.add(z);
        }
        return new BigNumber(y);

    }

    // Compara dos BigNumber. Torna 0 si són iguals, -1 si el primer és menor
// i torna 1 si el segon és menor
    public int compareTo(BigNumber other) {

        //En cas de que ambdos numeros siguin d'igual llargaria els comparam digit a digit fins que trobam una diferencia,
        //si no trobam significa que el numero es el mateix i retornam 0
        if (this.num.length() == other.num.length()) {
            for (int i = 0; i < this.num.length(); i++) {
                if (this.num.charAt(i) > other.num.charAt(i)){
                    return 1;
                } else if (other.num.charAt(i) > this.num.charAt(i)){
                    return -1;
                }
            }
            return 0;
          //En cas que el primer sigui mes llarg retornam 1 y en cas contrari -1
        } else if (this.num.length() > other.num.length()){
            return 1;
        } else if (other.num.length() > this.num.length()){
            return -1;
        } else{
            return 0;
        }
    }
    // Torna un String representant el número
    public String toString() {
        return this.num;
    }

    // Mira si dos objectes BigNumber són iguals
    public boolean equals(Object other) {
        BigNumber b = (BigNumber) other;
        return this.num.equals(b.num);
    }
}

