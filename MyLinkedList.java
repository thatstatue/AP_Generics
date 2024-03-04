public class MyLinkedList<T> {
    Node<T> first;
    //int size;

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }
    Integer getSize(){
        int result = 0;
        Node<T> current = first;
        while (current != null){
            current = current.getNext();
            result ++;
        }
        return result;
    }//correct but slow
    //میتونی جاش هرباری که یه چیزی اضافه یا حذف شد اینو پلاس یا ماینس کنی
    //مشکلش اینه که اگه یکی از بیرون کلاس دسترسی داشته باشه میتونه نود یه خونه ای اون وسط رو نال کنه که عملا داره سایز رو دستکاری میکنه یگه
    //ولی اون اینتی که سایزشو ریختی توش با این عملکر نمیفهمه

     public void pushFront(T data){
        //عنصری رو به اول لیست اضافه کنی
         first = new Node<>(data, first);

     }
     @Override
     public String toString(){ //حتی اگه از جنس ابجکت باشه نه از جنس بچه هاش
        //اگه که اوور راید کنی یه متدشو
         //وقتی خواست اجراش کنه میاد مال تو رو اجرا میکنه

         String  result = "[";
         Node<T> current = first;
         while (current != null){
             result = result.concat(current.getData().toString()); // به جای + توی استرینگ
             current = current.getNext();
             if (current!= null){
                 result = result.concat(" -> ");
             }
         }
         return result + "]";
     }

    public void clear(){
        setFirst(null);
    }// بقیشو میسپریم به گاربج کالکتر

// فقط یک عنصر اول رو داره از حنس نود T
    // اگه سایزشم بخوایم بدونیم int size
    //یه حالت دیگه هم هست doublyLinkedList و هزینه ش دوبرابره لینکدلیسته بجاش هرکدوم یه نکست و یه previous دارع
    //معمولا یه trade-off لگاریتمی بین حافظه و سرعت وجود داره
    //الان تو یه سری پوینتر داری به حافظه اضافه میکنی که هرکدوم یه بایت میگیرن بجاش سریع تر درمیاد

    //پریویس عنصر اول و نکست عنصر اخر به نال اشاره میکنه و باید حواسمون باشه بهش
    public static class Node <T>{
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            // نوع نود ورودی رو لازمه بگیم چون ممکنه اصن بخوایم این نو رو با استفاده از یه نود دیگه ای بسازیم
            this.data = data;
            this.next = next;
        }
//نود ممکنه مربوط به بیشتر از فقط یک لیست باشه
        //مثلا از یجا به بعد جفتشون به یه جای حافظه اشاره کنن
        //برای همین لازم نیست حتما به ازای هر لیست یک نود واسه همون داشته باشی
        //واسه همین بهتره اینرکلس واسه لینکدلیست نباشه

// generic ها نمیتونن پریمیتیو بگیرن
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}