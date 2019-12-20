/**
 * A simulation must be started from this class.
 * usage: java Simulator [options] -c <class name>  
 * @author naohaya
 * @version 1.2
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Simulator{
	/* global variables */

	/**
	* 与えられたクラス名
	*/
	String cname;

	/**
	* 指定されたスレッド数（プロセス数，初期値は10）
	*/
	int num;

	/**
	* 時間計測用フラグ
	*/
	Boolean measure = false;
	
	public static void main(String[] args){
		Simulator sim = new Simulator();
		sim.dispatcher(args);

	}

	/**
	* コマンドライン引数を解析する	
	*/
    void parseArguments(String[] args){
    	Boolean className = false;
    	Boolean numOfProcesses = false;

        for(Integer i = 0; i < args.length; i++){
            if(Objects.equals(args[i], "-h")){
                printHelp();
                System.exit(0);
            }
            else if(Objects.equals(args[i], "-t")){
            	this.measure = true;
            }
            else if(Objects.equals(args[i], "-c")){          	
                this.cname = args[++i];
                className = true;
            }
            else if(Objects.equals(args[i], "-p")){

            	try{
            		//Illegal argument.
            		this.num = Integer.parseInt(args[++i]);
            	}catch(NumberFormatException e){
            		printHelp();
            		System.exit(1);
            	}

            	if(this.num < 1) {
            		// Illegal value.
            		printHelp();
            		System.exit(1);
            	}

           		numOfProcesses = true;

            }
        	else {
        		System.out.println("No such option: "+args[i]);
        		printHelp();
        		System.exit(1);
        	}
        }

        if (!numOfProcesses) {
        	num = 10;
        }
        if (!className) {
        	printHelp();
        	System.exit(1);
        }
    }

    /**
    * 与えられたクラスを指定された数のスレッドで実行する
    */
    void dispatcher(String[] args) {
		MeasureTime timer = new MeasureTime(); // timer
		parseArguments(args);

		
		// create a global message queue
		/**
		* メッセージ・キュー
		*/
		MessageQueue mq = new MessageQueue(getNum());
		
		// type of callee class
		Class<?>[] types = {int.class, MessageQueue.class};
		
		// args of callee class
		Object[] arg = {null, null};
		
		// add the message queue to share in all processes
		arg[1] = mq;

		ExecutorService exec = Executors.newCachedThreadPool();	
		List<Future<?>> list = new ArrayList<Future<?>>();
		if(isMeasure())
			timer.start();
		try{	
			for (int i = 0; i < getNum(); i++) {
				//add the id of process
				arg[0] = Integer.valueOf(i);
				
				// get the constructor
				Constructor<?> cnst = Class.forName(getCname()).getConstructor(types);

				// instanciate the class then start it
				Future<?> future = exec.submit((Process)cnst.newInstance(arg));	
				list.add(future);

			}
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		exec.shutdown();
		// create processes as threads --obsolete--
		/*
		try {
			for (int i = 0; i < sim.getNum(); i++){
				//add the id of process
				arg[0] = Integer.valueOf(i);
				
				// get the constructor
				Constructor<?> cnst = Class.forName(sim.getCname()).getConstructor(types);

				// instanciate the class then start it
				((Process)cnst.newInstance(arg)).start();
			}
		}
		catch(RuntimeException re) {
			re.printStackTrace();
			System.err.println("Runtime Error.");
			System.exit(1);
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
			System.err.println("Class Not Found Exception.");
			System.exit(1);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		*/



			// wait for all threads dispatched.
		try {
			for (Future<?> future : list) {
				future.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		printSummary(); // print the execution summary.

		if (isMeasure()) {			
			timer.end();
			System.out.println("Execution Time: " + timer.getTime() + " msec.");

		}

    }

    /**
    * ヘルプを表示する
    */
    void printHelp(){
        System.out.println("java Simulator [OPTIONS] -c <Classname> [-p <Num. of processes>]");
        System.out.println("OPTIONS");
        System.out.println("    -h: Show help messages");
        System.out.println("    -t: Measure time elapsed");        
        System.out.println("    -p <num. of processes>: Give a num. of processes (greater than 1)"); 
    }

    /**
    * 実行のサマリを出力する
    */
    void printSummary(){
    	System.out.println("-----");
    	System.out.println("Execution of "+cname+" completed with "+num+" processes.");

    }

    /**
    * 指定されたスレッド数を参照する
    */
    int getNum() {
    	return this.num;
    }

    /**
    * 指定されたクラス名を参照する
    */
    String getCname(){
    	return this.cname;
    }

    /**
    * 時間計測をオプションで指定しているか確認する
    */
    Boolean isMeasure() {
    	return measure;
    }

}
