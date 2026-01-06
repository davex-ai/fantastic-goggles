import React, { useState, useEffect } from "react";

function AWSServices(){
    <h1>hiii</h1>
    const [services, setServices] = useState([])
    useEffect(()=>{
        getServices()
    }, [services])

    const getServices = async () => {
        const url = 'https://pricing.us-east-1.amazonaws.com/offers/v1.0/aws/index.json'
        const allServices = await fetch(url);
        const allServicesParsed = await  allServices.json()
        console.log(allServicesParsed)
        setServices(allServicesParsed)
    }

    getServices()
    return(
        <>{services.disclaimer}</>
    )
}
 export default AWSServices;