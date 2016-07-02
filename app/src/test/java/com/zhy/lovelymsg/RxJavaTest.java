package com.zhy.lovelymsg;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * RxJavaDemo
 * <p/>
 * 创建时间: 16/4/29 上午11:58 <br/>
 *
 * @author zhaohaiyang
 * @since v0.0.1
 */
public class RxJavaTest {


    @Test
    public void helloWorld() {

        //被观察者，事件源
        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello world!");
                subscriber.onCompleted();
            }
        });


        //订阅者
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };


        //通过subscribe函数就可以将我们定义的myObservable对象和mySubscriber对象关联起来，
        //这样就完成了subscriber对observable的订阅。
        myObservable.subscribe(mySubscriber);
    }


    @Test
    public void helloWorld_1() {

        //just用来创建只发出一个事件就结束的Observable对象
        Observable<String> myObservable = Observable.just("Hello world!");
        //如果只需要在onNext处理,可以用Action1
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
        myObservable.subscribe(onNextAction);


        //上面可以简写为
        Observable.just("Hello world!")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });

    }


    @Test
    public void operators_map() {
        Observable.just("Hello world!")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " I am coming!";
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }


    @Test
    public void operators_map_1() {
        Observable.just("Hello world!")
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                })
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return String.valueOf(integer);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }



}
