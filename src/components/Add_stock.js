import './Add_stock.css'
import { useState ,useEffect} from 'react';

function AddStock(props){
    const [code, setcode] = useState("--Select--");
 const selected_code=(Event)=>{
     const select_pro_code=Event.target.value;
     setcode(select_pro_code);
    
 }
 const [addmount, setaddmount]=useState(0);
 const [addprice, setaddprice]=useState(0);
 const input_amount=(event)=>{setaddmount(event.target.value)}
 const input_price=(event)=>{setaddprice(event.target.value)}
 useEffect(() => {
    props.selectToApp(code);
    props.getAmountFromAdd_stock(parseInt(addmount));
    props.getPriceFromAdd_stock(parseInt(addprice))
  }, [code,addmount,addprice,props]);

    return(
       
        <div className="containerstock">
             <h2 className="heading">Add Stock</h2>
            <div>
            <div className="select_container">
        <b>Select a Product code</b><br/>
        <select className="select" onChange={selected_code}>
            <option value="Product 01">Product 01</option>
            <option value="Product 02">Product 02</option>
            <option value="Product 03">Product 03</option>
        </select>
    
    </div></div><br/>
            <div className="input_01">
                <b>Items Recieved</b><br/>
                <input className="amount_input" type="text" value={addmount} onChange={input_amount}/>
            </div><br/>
            <div className="input_02">
                <b>Price per item Recieved</b><br/>
                <input className="price_input" type="text" value={addprice} onChange={input_price}/>
            </div>
            <div className="addbutton">
                <button className="buttonAdd" onClick={props.Decision}><b>Add stock</b></button>
            </div>

        </div>
    );
}
export default AddStock;