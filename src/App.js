import './App.css';
import { useState}from 'react';
import AddStock from './components/Add_stock';
import Stocklevel from './components/Stock_level';
import RemoveStock from './components/Remove_stock';


function App() {
  const product_1="Product 01";
  const product_2="Product 02";
  const product_3="Product 03";

  const [pro_1_amount,setamount_1]=useState(5);
  const [pro_2_amount,setamount_2]=useState(12);
  const [pro_3_amount,setamount_3]=useState(2);

  const [pro_1_price,setprice_1]=useState(400.89);
  const [pro_2_price,setprice_2]=useState(78.83);
  const [pro_3_price,setprice_3]=useState(56.03);

  const[ getcode, setgetcode] = useState('');
  const selectToApp = (data) => {
   setgetcode(data)
  }
  const [added_stock,setadded_stock]=useState(0);
  const [added_price,setadded_price]=useState(0);
  const getAmountFromAdd_stock=(amountAdded)=>{setadded_stock(amountAdded)}
  const getPriceFromAdd_stock=(priceAdded)=>{setadded_price(priceAdded)}

  function Decision(e){
    e.preventDefault();
    if(getcode === product_1){
      setamount_1(pro_1_amount +  added_stock);
      setprice_1((pro_1_price + added_price*added_stock )/(pro_1_amount + added_stock));
    }
    if (getcode ===product_2) {
      setamount_2(pro_2_amount + added_stock);
      setprice_2((pro_2_price + added_price*added_stock )/(pro_2_amount + added_stock));
    }
    if(getcode === product_3){
      setamount_3(pro_3_amount + added_stock);
      setprice_3((pro_3_price + added_price*added_stock )/(pro_3_amount + added_stock));
    }
   
  }

  //This is  for the remove part

  const[ getcode1, setgetcode1] = useState('');
  const selectToApp1 = (data) => {
   setgetcode1(data)
  }
  const [added_email,setadded_email]=useState("test@gmail.com");
  const [added_bought,setadded_bought]=useState(0);
  const getemail=(Email)=>{setadded_email(Email)}
  const getbought=(bought)=>{setadded_bought(bought)}  
  
 // const list=["jake@gmail.com","lucy@gmail.com","moyi@gmail.com"]

 
  function Decision_2(e){
   e.preventDefault();
    if(getcode1 === product_1){
        if(localStorage.getItem(added_email)==null){
     
          localStorage.setItem(added_email, added_email);
          setamount_1(pro_1_amount - added_bought);
          setprice_1((pro_1_price + added_price )/(pro_1_amount - added_stock));
          //alert("added 1");
        } else{
          alert("The email has already been used");
    }
  }
    if (getcode1 ===product_2) {
      if(localStorage.getItem(added_email)==null){
     
        localStorage.setItem(added_email, added_email);
        setamount_2(pro_2_amount - added_bought);
        setprice_2((pro_2_price + added_price )/(pro_2_amount - added_stock));
       // alert("added 2");
      } else{
        alert("The email has already been used");
    }
    }
    if(getcode1 === product_3){
        if(localStorage.getItem(added_email)==null){
     
            localStorage.setItem(added_email, added_email);
            setamount_3(pro_3_amount - added_bought);
            setprice_3((pro_3_price + added_price )/(pro_3_amount - added_stock));
         //   alert("added 3");
       } else{
        alert("The email has already been used");
     }
    }//else{alert("nothing")}
     
  }

  return (
    <div className="App">
    <Stocklevel pro_name_1={product_1}  pro_name_2={product_2} pro_name_3={product_3}
    amount_1={pro_1_amount} amount_2={pro_2_amount} amount_3={pro_3_amount} price_1={pro_1_price} price_2={pro_2_price} price_3={pro_3_price}/>
    <AddStock  selectToApp={selectToApp} getAmountFromAdd_stock={getAmountFromAdd_stock} 
    getPriceFromAdd_stock={getPriceFromAdd_stock} Decision={Decision}/>
   <RemoveStock selectToApp1={selectToApp1} getemail={getemail}  getbought={getbought} Decision_2={Decision_2}  />
  
    </div>
  );
 }

export default App;

