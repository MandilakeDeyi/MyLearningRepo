import './Select_menu.css'
import { useState } from 'react';


function SelectMenu(props){
 const [code, setcode] = useState("--Select--");
 const selected_code=(Event)=>{
     const select_pro_code=Event.target.value;
     setcode(select_pro_code);
    
 }
 const handledata=()=>{props.selectToApp(code)}
return(
    <div className="select_container">
        <b>Select a Product code</b><br/>
        <select className="select" onChange={selected_code}>
            <option value="product_01">Product 01</option>
            <option value="product_02">Product 02</option>
            <option value="product_03">Product 03</option>
        </select>
    
    </div>
);
}
export default SelectMenu;