import './Product.css'

function Product(props){
    return(
        <div className="containerpro">
           <div className="row_01" > <p><b>{props.first_pro_name}</b></p><p className="amount">{props.amount}</p></div>
            <p>{props.price}</p>
        </div>
    );
}
export default Product;