import React, { useEffect, useState } from 'react'
import './App.css'
 
function Country() {
    //STATE REQUIRED FOR READING API INFO
    const [country, setCountry] = useState (null)
    const [loading, setLoading] = useState (true)   
     const [error, setError] = useState (null)

     const countryName = "Britain"
 
     //UPDATE OUR STATE ISING USEEFFECT HOOK
     useEffect(() => {
         fetch(`https://restcountries.com/v3.1/name/${countryName}`)
        .then(response => {
            if(!response.ok){
                throw new Error('Failed to fetch country data')
            } else {    
              // console.log(response.json());
                        
               return response.json()
            }
        })
        .then(data => {
            // LOADING API INFO INTO COUNTRY STATE
            setCountry(data[0])
            setLoading(false)
        })
        .catch(error => {
            setError(error.message)
            setLoading(false)
        })
     }, [countryName])

     if(loading){
        return <p>Loading country Data ...</p>
     }
     if(error){
        return <p>Error: {error}</p>
     }

  return (
    <div className='container'>
      <h2>{country.name.common}</h2>
      <img className='flag' src={country.flags.png} alt="" />
      <p><strong>Population: </strong><strong>{country.population.toLocaleString()}</strong></p>
      <p><strong>Region: </strong><strong>{country.region}</strong></p>
      <p><strong>Capital: </strong>{country.capital}</p>
      <p><strong>Currency: </strong> {country.currencies.GBP.name}</p>
      <p><strong>Start Of Week: </strong>{country.startOfWeek}</p>
    </div>
  )
}

export default Country
