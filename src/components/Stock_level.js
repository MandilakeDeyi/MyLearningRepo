import Product from "./Products";
import './Stock_level.css';

function Stocklevel(props){
    return(
        <div className="list">
            <h2 className="heading">Stock Levels</h2>
            <Product first_pro_name={props.pro_name_1} amount={props.amount_1}  price={props.price_1}/>
            <Product first_pro_name={props.pro_name_2} amount={props.amount_2}  price={props.price_2}/>
            <Product first_pro_name={props.pro_name_3} amount={props.amount_3}  price={props.price_3}/>
           
        </div>
    );
}
export default Stocklevel;