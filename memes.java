package brasilmemes.memeslite;

class memes{

    private final String nome;
    private int resID;

    memes(String nome, int resID){

        this.nome = nome;
        this.resID = resID;
    }

    public String getNome(){
        return nome;
    }

    public int getResId(){
        return resID;
    }

    @Override
    public String toString(){
        return nome;
    }

}