import java.util.ArrayList;
import java.util.LinkedList;

public class Application implements Runnable{
    @Override
    public void run() {
        ArrayList<String> stringArrayList = new ArrayList<>(); //فقط میذاره استرینگ بهش پاس بدی
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        //زمان اجرای برنامه اینتجراریلیست و استرینگ اریلیستمون براش هیچ فرقی نداره و رفتارشون یکسانه
        // موقع کامپایل بررسی میشه و جلوشو میگیره که ابجکت اشتباهی پاس ندی
        stringArrayList.add("First");
        stringArrayList.add("Second");
        for (String string : stringArrayList){
            System.out.println(string);
        } //concurrent modification exception is probable
        for (int i = 0; i < stringArrayList.size(); i++){
            System.out.println(stringArrayList.get(i));
        } //safer but slower, checks the size every time

        /*
        * نوع ثبت در حافظه ی اری لیست
        * vector comp???
        * حافظه ی عنصر اول رو داره و بقیه زو میذاره خونه های بعدض
        خ.بی*
        * بدی : میخوای پنجمی رو دیلیت کنی همه بعدیاشو باید یه خونه جابجا کنی
        کار افیشنت ترش اینه کهیه ارایه کوچیکتر بشازیم و همه جز پنجمیه رو بریزیم توش* */

        LinkedList<Object> objectLinkedList = new LinkedList<>();
        //از یه تعداد node دوقسمتی تشگیل شده اولی data دومیش next Node

        //ادرس خونه اولشو داره و یک نکست که هر خونه ادرس بعدیشو داره
        //بدی: بخوای به کا امی برسی باید کا بار بپرسی بعدیت کیه
        //خوبی: بخوای اضافه کنی
        //------------------------------------------------------------
        System.out.println();

        MyLinkedList<String> stringLinkedList = new MyLinkedList<>();
        stringLinkedList.pushFront("A");
        stringLinkedList.pushFront("B");
        stringLinkedList.pushFront("C");
        System.out.println(stringLinkedList.toString());
        stringLinkedList.clear();
        System.out.println(stringLinkedList.toString());
        stringLinkedList.pushFront("A");
        stringLinkedList.pushFront("B");
        System.out.println(stringLinkedList.toString());



    }
}
