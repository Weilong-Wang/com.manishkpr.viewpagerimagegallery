package com.manishkpr.viewpagerimagegallery;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
       
	ArrayList<Product> productsList=new ArrayList<Product>();


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button Select=(Button)findViewById(R.id.button2);
	 Button Update=(Button)findViewById(R.id.button3);  
    // final String	PRODUCTS_URL	= "https://staging.apitaxitreats.com/api/v1/product_lists";
     final TextView cartridgeView=(TextView)findViewById(R.id.textView3);
	 final TextView stockView=(TextView)findViewById(R.id.textView5);
    final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

   
    ImageAdapter adapter = new ImageAdapter(this);
    viewPager.setAdapter(adapter);
    

    Select.setOnClickListener(new OnClickListener()
    {
    	public void onClick(View v)
    	{
    	
    		int position=viewPager.getCurrentItem();
    		cartridgeView.setText((ImageAdapter.productArray[position]).name);    		
    		stockView.setText(String.valueOf((ImageAdapter.productArray[position]).maxQuantity));
    		
    	}
    });
    
    Update.setOnClickListener(new View.OnClickListener()
    {
  		
  		@Override
  		public void onClick(View v) 
  		{
  			
  			DownloadProductsTask uTask=new DownloadProductsTask();
  			uTask.execute("https://staging.apitaxitreats.com/api/v1/product_lists");
  		}
  	});
    
    
  }
  
  
 
  
  
  class DownloadProductsTask extends  AsyncTask<String, Void, String>{  
	  
	  JSONArray responseArray;
      @Override  
      protected void onPreExecute() {  
          //第一个执行方法  
          super.onPreExecute();  
      }  
        
      @Override  
      protected String doInBackground(String... params) {  
          //第二个执行方法,onPreExecute()执行完后执行  
    	  try
	        {
             System.out.println(params[0]);
    		  // Open an http connection
              HttpClient httpClient = getNewHttpClient();
             

              // Get data
              HttpGet httpGet = new HttpGet(params[0]);
              httpGet.addHeader("Authorization", "Token token=\"5a77173531219b63a9c55f2f3359dd05\"");
              HttpResponse httpResponse = httpClient.execute(httpGet);

              // Collect the response
              HttpEntity httpEntity = httpResponse.getEntity();
              InputStream is = httpEntity.getContent();
              BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
              StringBuilder sb = new StringBuilder();

              String line = null;
              while ((line = reader.readLine()) != null)
              {
                  sb.append(line).append("\n");
              }

              is.close();
              // Print the server response
              System.out.println(sb.toString());
              
             return sb.toString();
	        }
	        catch (Exception e)
	        {
	        	System.out.println("exception occures");
              e.printStackTrace();
	        }
			return null;
      } 
      
      @Override  
      protected void onPostExecute(String result)
      {  
          //doInBackground返回时触发，换句话说，就是doInBackground执行完后触发  
          //这里的result就是上面doInBackground执行后的返回值，所以这里是"执行完毕"  
    	  try {
			responseArray = new JSONArray(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         parseProductsArray();
    	 //System.out.println("zaizhelia"+result);
    	 // System.out.println("It's going to do parseProductsArray()");
      }
      
      
      
      public void parseProductsArray()
		{
			
			JSONObject jObj;
			for (int i=0; i<responseArray.length(); i++)
			{
				try
				{
					jObj = (JSONObject) responseArray.get(i);
					//System.out.println(jObj.toString());
					if (jObj.getBoolean("success"))
					{
						int id = jObj.getInt("id");
						String name = jObj.getString("name");
						double price = jObj.getDouble("price");
						String filename = jObj.getString("image_filename");
						String description = jObj.getString("description");
						int quantity = jObj.getInt("quantity");
						boolean over21 = jObj.getBoolean("over_21");
						
						String url = "";
						String adImage = "";
						String popupImage = "";
						String selectionImage = "";
						
						try
						{
							JSONArray jImageArray = jObj.getJSONArray("images");
							// System.out.println(jImageArray.toString());

							for (int j = 0; j < 3; j++)
							{
								url = jImageArray.getJSONObject(j).getJSONObject("image").getString("cname_image_url");
								// System.out.println(url);

								if (url.contains("ad.png"))
								{
									adImage = url;
								}
								else if (url.contains("popup.png"))
								{
									popupImage = url;
								}
								else
								{
									selectionImage = url;
								}
							}

						}
						catch (JSONException e)
						{
							System.err.println(url + " not found");
							//e.printStackTrace();
						}

						System.out.println(adImage);
						System.out.println(popupImage);
						System.out.println(selectionImage);

						productsList.add(new Product(id, name, price, filename, description, quantity, selectionImage, adImage, popupImage, over21));
					}
				}
				catch (JSONException e)
				{
					e.printStackTrace();
				}
			}
			
			//cboProducts.setModel(new DefaultComboBoxModel(productsList.toArray()));
			//cboProducts.setEnabled(true);
		}

      @Override  
      protected void onProgressUpdate(Void... progress)
      {  
          
      }  
     
  }  
  
  
  public static HttpClient getNewHttpClient()
	{
		try
		{
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);

			SSLSocketFactory sf = new MySSLSocketFactory(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpParams params = new BasicHttpParams();
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));

			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);

			return new DefaultHttpClient(ccm, params);
		}
		catch (Exception e)

		{
	
			return new DefaultHttpClient();
		}
	}

  
}
