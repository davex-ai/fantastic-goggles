import { useState } from 'react'
import './App.css'
import CssBaseline from '@mui/material/CssBaseline'
import Container from '@mui/material/Container'
import FormControlLabel from '@mui/material/FormControlLabel' 
import Checkbox from '@mui/material/Checkbox' 
import RadioGroup from '@mui/material/RadioGroup' 
import FormControl from '@mui/material/FormControl' 
import FormLabel from '@mui/material/FormLabel' 
import Radio from '@mui/material/Radio' 
import Select from '@mui/material/Select' 
import MenuItem from '@mui/material/MenuItem'
import Button from '@mui/material/Button';



function App() {

  const [checkbox, setCheckbox] = useState(false)
  const [radio, setRadio] = useState('First')

  const [formData, setFormData] = useState({
    name: '',
    gender: '',
    country: '',
    // name: false,
  })
  const handleChange = (event) => {
    const {name, value, type, checked} = event.target 
    setFormData((prev) => ({
      ...prev,
      [name]: type === 'checkbox' ? checked : value,
    }))
  }
  return (
    <> 
    <Container>
    <CssBaseline fixed/>
    <h1>Vite + React + Nexora</h1>
    <FormControlLabel 
    control={<Checkbox 
    name="agree" 
    checked={checkbox} 
    onChange={() => setCheckbox(!checkbox)}
    />} 
    label='I agree to the terms and condition'
    />
    <FormControl component='fieldset' margin="normal">
    <FormLabel>Gender</FormLabel>
    <RadioGroup name='gender' onChange={e => setRadio(e.target.value)} row>
      <FormControlLabel value='male' control={<Radio/>} label="male"/>
      <FormControlLabel value='female' control={<Radio/>} label="female"/>
      <FormControlLabel value='other' control={<Radio/>} label="other"/>
    </RadioGroup>
    </FormControl>
    <Button fullWidth variant="contained" color="primary" type="submit">Submit</Button>

    <FormControl fullWidth margin='normal'>
      <FormLabel>Country</FormLabel>
      <Select name='country' value={formData.country} onChange={handleChange} displayEmpty >
        <MenuItem value="">-- Select --</MenuItem>
        <MenuItem value="us">United States</MenuItem>
        <MenuItem value="ca">Canada</MenuItem>
        <MenuItem value="uk">United Kingdom</MenuItem>
      </Select>

    </FormControl>
    </Container> 
    </>

  )
}

export default App
