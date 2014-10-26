using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using QuraanMemorizer.Models;
using QuraanMemorizer.DAL;

namespace QuraanMemorizer.Controllers
{
    public class ReciterController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET api/Reciter
        public IQueryable<Reciter> GetReciter()
        {
            return db.Reciter;
        }

        // GET api/Reciter/5
        [ResponseType(typeof(Reciter))]
        public IHttpActionResult GetReciter(int id)
        {
            Reciter reciter = db.Reciter.Find(id);
            if (reciter == null)
            {
                return NotFound();
            }

            return Ok(reciter);
        }

        // PUT api/Reciter/5
        public IHttpActionResult PutReciter(int id, Reciter reciter)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != reciter.Id)
            {
                return BadRequest();
            }

            db.Entry(reciter).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ReciterExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST api/Reciter
        [ResponseType(typeof(Reciter))]
        public IHttpActionResult PostReciter(Reciter reciter)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Reciter.Add(reciter);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = reciter.Id }, reciter);
        }

        // DELETE api/Reciter/5
        [ResponseType(typeof(Reciter))]
        public IHttpActionResult DeleteReciter(int id)
        {
            Reciter reciter = db.Reciter.Find(id);
            if (reciter == null)
            {
                return NotFound();
            }

            db.Reciter.Remove(reciter);
            db.SaveChanges();

            return Ok(reciter);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool ReciterExists(int id)
        {
            return db.Reciter.Count(e => e.Id == id) > 0;
        }
    }
}