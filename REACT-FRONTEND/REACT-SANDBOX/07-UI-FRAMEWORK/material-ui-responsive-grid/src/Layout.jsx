import React from 'react'
import { Box, Grid, List, ListItem, ListItemButton, ListItemIcon, ListItemText, Paper } from '@mui/material'

function Layout() {
  return (
    <Box sx={{ flexGrow: 1, p: 2}}> 
        <Grid  sx={{marginTop: "20px"}}><Paper sx={{height: "40px", textAlign: "center", paddingTop: "20px", marginBottom: "30px"}}>Header</Paper></Grid> 

          <Grid container spacing={2}> 
          <Grid container spacing={2} direction={'column'} >
             <Grid size={4}>
               <Paper sx={{  
                 textAlign: "center",
                 fontWeight: "bold", textAlignLast: "center", width: "200px" }}>
                  NAVITEMS
                  <nav aria-label='main mailbox folders'>
                    <List>
                  <ListItem disablePadding>
                    <ListItemButton>
                      {/* <ListItemIcon>
                      </ListItemIcon> */}
                      <ListItemText primary="Nav Item 1"></ListItemText>
                    </ListItemButton>
                  </ListItem>
                  <ListItem disablePadding>
                    <ListItemButton>
                      {/* <ListItemIcon>
                      </ListItemIcon> */}
                      <ListItemText primary="Nav Item 2"></ListItemText>
                    </ListItemButton>
                  </ListItem>
                  <ListItem disablePadding>
                    <ListItemButton>
                      {/* <ListItemIcon>
                      </ListItemIcon> */}
                      <ListItemText primary="Nav Item 3"></ListItemText>
                    </ListItemButton>
                  </ListItem>
                  <ListItem disablePadding>
                    <ListItemButton>
                      {/* <ListItemIcon>
                      </ListItemIcon> */}
                      <ListItemText primary="Nav Item 4"></ListItemText>
                    </ListItemButton>
                  </ListItem>
                  
                   </List>
                  </nav>
                 </Paper> 
                 </Grid>
               </Grid>

               <Grid container direction={"column"} spacing={2}>
               <Grid size={5}  width={302}><Paper sx={{height: "60px", textAlign: "center", paddingTop: "20px"}}> Main Content 1 </Paper></Grid> 
               <Grid size={5}  width={302}><Paper sx={{height: "60px", textAlign: "center", paddingTop: "20px"}}> Main Content 3 </Paper></Grid> 
               </Grid>

               <Grid container direction={"column"} spacing={2}>
               <Grid size={5}  width={302}><Paper sx={{height: "60px", textAlign: "center", paddingTop: "20px"}}> Main Content 2 </Paper></Grid> 
               <Grid size={5}  width={302}><Paper sx={{height: "60px", textAlign: "center", paddingTop: "20px"}}> Main Content 4 </Paper></Grid> 
               </Grid>

    </Grid>
    <Grid  sx={{marginTop: "20px"}}><Paper sx={{height: "40px", textAlign: "center", paddingTop: "20px"}}>Footer</Paper></Grid> 
    </Box>
  )
}
export default Layout
