import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;


/* a stub for your team's fuzzer */
public class Fuzzer {

    private static final String OUTPUT_FILE = "fuzz.txt";
    private static Instruction[] INSTS = Instruction.values(); //Store all Instructions
    private static Random rand = new Random();
    private static int max_length = 1022;

    public static String Random_String(int length) {
        char c;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            c = (char) getNum(33, 126);
            str.append(c);
        }
        return str.toString();
    }

    //Generate random number
    public static int getNum(int start, int end){
        return (int)(Math.random()*(end-start+1)+start);
    }


    public static void main(String[] args) throws IOException {
        System.out.println(Instruction.getBNF());
        FileOutputStream out = null;
        PrintWriter pw = null;
        try {
            out = new FileOutputStream(OUTPUT_FILE);
            pw = new PrintWriter(out);

            int record = 0;

            int change = getNum(0,9);
            if(change <= 5 ){
                //regular type--number:45
                int regular_type = 45;
                for(int i = 0; i < regular_type; i++) {
                    int random_number_control_URL = getNum(1,1014);
                    int random_number_control_username = getNum(1,1015-random_number_control_URL);
                    int random_number_control_password = getNum(1,1016-random_number_control_URL-random_number_control_username);
                    pw.println("get" + " " + Random_String(10));
                    switch (rand.nextInt(5)) {
                        case 0:
                            pw.println("get" + " " + Random_String(getNum(1,1018)));
                            pw.println("get" + " " + Random_String(getNum(1,1018)));
                            pw.println("get" + " " + Random_String(getNum(1,1018)));
                            pw.println("get" + " " + Random_String(getNum(1,1018)));
                            pw.println("get" + " " + Random_String(getNum(1,1018)));
                            record = record + 5;
                            break;
                        case 1:
                            pw.println("rem " + " " + Random_String(getNum(1,1018)));
                            pw.println("rem " + " " + Random_String(getNum(1,1018)));
                            pw.println("rem " + " " + Random_String(getNum(1,1018)));
                            pw.println("rem " + " " + Random_String(getNum(1,1018)));
                            pw.println("rem " + " " + Random_String(getNum(1,1018)));
                            record = record + 5;
                            break;
                        case 2:
                            pw.println("save" + " " + "a" + " " + "b" );
                            pw.println("save" + " " + "a" + " " + "b" );
                            pw.println("save" + " " + "a" + " " + "b" );
                            pw.println("save" + " " + "a" + " " + "b" );
                            pw.println("save" + " " + "a" + " " + "b" );
                            record = record + 5;
                            break;
                        case 3:
                            pw.println("put" + " " + Random_String(random_number_control_URL) + " " + Random_String(random_number_control_username) + " " + Random_String(random_number_control_password));
                            pw.println("put" + " " + Random_String(random_number_control_URL) + " " + Random_String(random_number_control_username) + " " + Random_String(random_number_control_password));
                            pw.println("put" + " " + Random_String(random_number_control_URL) + " " + Random_String(random_number_control_username) + " " + Random_String(random_number_control_password));
                            pw.println("put" + " " + Random_String(random_number_control_URL) + " " + Random_String(random_number_control_username) + " " + Random_String(random_number_control_password));
                            pw.println("put" + " " + Random_String(random_number_control_URL) + " " + Random_String(random_number_control_username) + " " + Random_String(random_number_control_password));
                            record = record + 5;
                            break;
                        default:
                            pw.println("list");
                            record++;
                    }
                }
                //url, username and password
                String all_put_circulation_url = Random_String(1012);
                String all_put_circulation_username = Random_String(2);
                String all_put_circulation_password = Random_String(2);
                String all_put_circulation_url_1 = Random_String(1012);
                String all_put_circulation_username_1 = Random_String(2);
                String all_put_circulation_password_1 = Random_String(2);
                switch (rand.nextInt(8)) {
                    case 0:
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username + " " + all_put_circulation_password);
                        record++;
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username + " " + all_put_circulation_password);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        pw.println("rem" + " " + all_put_circulation_url);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        break;
                    case 1:
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username + " " + all_put_circulation_password);
                        record++;
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username + " " + all_put_circulation_password_1);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        pw.println("rem" + " " + all_put_circulation_url);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        break;
                    case 2:
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username + " " + all_put_circulation_password);
                        record++;
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username_1 + " " + all_put_circulation_password);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        pw.println("rem" + " " + all_put_circulation_url);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        break;
                    case 3:
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username + " " + all_put_circulation_password);
                        record++;
                        pw.println("put" + " " + all_put_circulation_url_1 + " " + all_put_circulation_username + " " + all_put_circulation_password);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        pw.println("rem" + " " + all_put_circulation_url);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url_1);
                        record++;
                        pw.println("rem" + " " + all_put_circulation_url_1);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url_1);
                        record++;
                        break;
                    case 4:
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username + " " + all_put_circulation_password);
                        record++;
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username_1 + " " + all_put_circulation_password_1);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        pw.println("rem" + " " + all_put_circulation_url);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        break;
                    case 5:
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username + " " + all_put_circulation_password);
                        pw.println("put" + " " + all_put_circulation_url_1 + " " + all_put_circulation_username + " " + all_put_circulation_password_1);
                        pw.println("get" + " " + all_put_circulation_url);
                        pw.println("rem" + " " + all_put_circulation_url);
                        pw.println("get" + " " + all_put_circulation_url);
                        pw.println("get" + " " + all_put_circulation_url_1);
                        pw.println("rem" + " " + all_put_circulation_url_1);
                        pw.println("get" + " " + all_put_circulation_url_1);
                        break;
                    case 6:
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username + " " + all_put_circulation_password);
                        record++;
                        pw.println("put" + " " + all_put_circulation_url_1 + " " + all_put_circulation_username_1 + " " + all_put_circulation_password);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        pw.println("rem" + " " + all_put_circulation_url);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url_1);
                        record++;
                        pw.println("rem" + " " + all_put_circulation_url_1);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url_1);
                        record++;
                        break;
                    default:
                        pw.println("put" + " " + all_put_circulation_url + " " + all_put_circulation_username + " " + all_put_circulation_password);
                        record++;
                        pw.println("put" + " " + all_put_circulation_url_1 + " " + all_put_circulation_username_1 + " " + all_put_circulation_password_1);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        pw.println("rem" + " " + all_put_circulation_url);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url_1);
                        record++;
                        pw.println("rem" + " " + all_put_circulation_url_1);
                        record++;
                        pw.println("get" + " " + all_put_circulation_url_1);
                        record++;
                }

                switch (rand.nextInt(8)) {
                    case 0:
                        if(record < 1024){
                            pw.println("put" + " " + Random_String(20)+ " " + Random_String(20) + " " + Random_String(20) + " " + Random_String(20));
                            record++;
                        }
                        break;
                    case 1:
                        if(record < 1024){
                            pw.println("put" + " " + "abc");
                            record++;
                        }
                        break;
                    case 2:
                        if(record < 1024){
                            pw.println("rem" + " ");
                            record++;
                        }
                        break;
                    case 3:
                        if(record < 1024){
                            pw.println("save" + " " + "a");
                            record++;
                        }
                        break;
                    case 4:
                        if(record < 1024){
                            pw.println("list" + " " + "a");
                            record++;
                        }
                        break;
                    case 5:
                        if(record < 1024){
                            pw.println("save" + " ");
                            record++;
                        }
                        break;
                    case 6:
                        //put four parameters
                        if(record < 1024){
                            pw.println("put" + " " + Random_String(20)+ " " + Random_String(20) + " " + Random_String(20) + " " + Random_String(20));
                            record++;
                        }
                        break;
                    default:
                        //one line have 1024 chars
                        if(record < 1024){
                            pw.println("put" + " " + Random_String(1016)+ " " + Random_String(1) + " " + Random_String(1));
                            record++;
                        }
                }

            }


            if(change == 6 || change == 7){
                while(record < 1023){
                    pw.println("put" + " " + Random_String(1014)+ " " + Random_String(1) + " " + Random_String(1));
                    record++;
                }

                int change_0 = getNum(0,1);
                if(change_0 == 0){
                    pw.println("save" + " " + "a" + " " + "b" );
                }
                if(change_0 == 1){
                    pw.println("masterpw" + " " + "abcd");
                }



            }
            if(change == 8){
                while(record < 1023){
                    pw.println("put" + " " + Random_String(1)+ " " + Random_String(1014) + " " + Random_String(1));
                    record++;
                }
                int change_1 = getNum(0,1);
                if(change_1 == 0){
                    pw.println("save" + " " + "a" + " " + "b" );
                }
                if(change_1 == 1){
                    pw.println("masterpw" + " " + "abcd");
                }
            }
            if(change == 9){
                while(record < 1024){
                    pw.println("put" + " " + Random_String(1)+ " " + Random_String(1) + " " + Random_String(1014));
                    record++;
                }
                int change_2 = getNum(0,1);
                if(change_2 == 0){
                    pw.println("save" + " " + "a" + " " + "b" );
                }
                if(change_2 == 1){
                    pw.println("masterpw" + " " + "abcd");
                }

            }

        }catch (Exception e){
            e.printStackTrace(System.err);
            System.exit(1);
        }finally{
            if (pw != null){
                pw.flush();
            }
            if (out != null){
                out.close();
            }
        }

    }

}
