import './Remove_stock.css'
import { useState ,useEffect } from 'react';
function RemoveStock(props){

    const [code1, setcode1] = useState("--Select--");
    const selected_code_1=(Event)=>{
        const select_pro_code_1=Event.target.value;
        setcode1(select_pro_code_1);
    }
        const [email, setemail]=useState("test@gmail.com");
        const [amount_bought, setamount_bought]=useState(0);
        const input_email=(event)=>{setemail(event.target.value)}
        const input_amount_bought=(event)=>{setamount_bought(event.target.value)}
        useEffect(() => {
            props.selectToApp1(code1);
            props.getemail(email);
            props.getbought(parseInt(amount_bought))
          }, [amount_bought,code1,email,props]);
      
    
    return(
        <div className="remove_container">
           <h2 className="hey">Remove Stock</h2>
           <div className="remove_select">
           <b>Select a Product code</b><br/>
        <select className="select" onChange={selected_code_1}>
            <option value="Product 01">Product 01</option>
            <option value="Product 02">Product 02</option>
            <option value="Product 03">Product 03</option>
        </select>
           </div>
           <div>
               <b>Buyer Email Address</b><br/>
               <input type="email" className="email"  onChange={input_email}/>
           </div>
           <div>
               <b>Items Bought</b><br/>
               <input type="text" className="bought" onChange={input_amount_bought}/>
           </div>
           <div>
               <button className="ship_button" onClick={props.Decision_2}><b>Item Shipped</b></button>
           </div>
        
        </div>
    );
}
export default RemoveStock;